package com.bell.project.dao.user;

import com.bell.project.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager em;

    @Autowired
    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public void addUser(User user) {
        TypedQuery<Nationality> query = em.createQuery("SELECT n FROM Nationality n WHERE n.code = ?1", Nationality.class);
        query.setParameter(1, user.getNationality().getCode());
        try {
            user.setNationality(query.getSingleResult());
        } catch (NoResultException e) {
            throw new RuntimeException("Nationality with provided code not found. Check the code and try again", e);
        }

        Office of = em.getReference(Office.class, user.getOffice().getId());
        user.setOffice(of);

        TypedQuery<DocumentType> query2 = em.createQuery("SELECT d FROM DocumentType d WHERE d.code = ?1", DocumentType.class);
        query2.setParameter(1, user.getDocument().getDocumentType().getCode());
        DocumentType docT;
        try {
            docT = query2.getSingleResult();
            user.getDocument().setDocumentType(docT);
        } catch (NoResultException e) {
            throw new RuntimeException("Document with provided code not found. Check the code and try again", e);
        }

        Document doc = user.getDocument();
        user.setDocument(null);
        em.persist(user);

        user.setDocument(doc);
        doc.setUser(user);
        em.persist(user.getDocument());
    }

    @Override
    public void updateUser(User user) {
        User us = em.find(User.class, user.getId());
        if (us == null) {
            throw new EntityNotFoundException("User with provided ID not found");
        } else {
            Office of = em.getReference(Office.class, user.getOffice().getId());
            us.setOffice(of);

            us.setFirstName(user.getFirstName());
            us.setSecondName(user.getSecondName());
            us.setMiddleName(user.getMiddleName());
            us.setPosition(user.getPosition());
            us.setPhone(user.getPhone());
            us.getDocument().setNumber(user.getDocument().getNumber());
            us.getDocument().setDate(user.getDocument().getDate());

            TypedQuery<DocumentType> query = em.createQuery("SELECT d FROM DocumentType d WHERE d.name = ?1", DocumentType.class);
            query.setParameter(1, user.getDocument().getDocumentType().getName());
            DocumentType docT;
            try {
                docT = query.getSingleResult();
                us.getDocument().setDocumentType(docT);
            } catch (NoResultException e) {
                throw new RuntimeException("DocumentType with provided name not found. Check the name and try again", e);
            }

            TypedQuery<Nationality> query2 = em.createQuery("SELECT n FROM Nationality n WHERE n.code = ?1", Nationality.class);
            query2.setParameter(1, user.getNationality().getCode());
            Nationality nat = query2.getSingleResult();
            if (nat != null) {
                try {
                    us.setNationality(nat);
                } catch (NoResultException e) {
                    throw new RuntimeException("Nationality with provided code not found. Check the code and try again", e);
                }
            }

            us.setIsIdentified(user.getIsIdentified());
        }
    }

    @Override
    public List<User> getUsersByOffice(Long officeId, String name, String lastName, String middleName,
                                       String position, String docCode, String citizenshipCode) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> user = criteria.from(User.class);
        List<Predicate> predicates = new ArrayList<>();

        if (officeId != null) {
            predicates.add(builder.equal(user.get("office"), officeId));
        }
        if (name != null) {
            predicates.add(builder.equal(user.get("firstName"), name));
        }
        if (lastName != null) {
            predicates.add(builder.equal(user.get("lastName"), lastName));
        }
        if (middleName != null) {
            predicates.add(builder.equal(user.get("middleName"), middleName));
        }
        if (position != null) {
            predicates.add(builder.equal(user.get("position"), position));
        }
        if (docCode != null) {
            predicates.add(builder.equal(user.get("document"), docCode));
        }
        if (citizenshipCode != null) {
            predicates.add(builder.equal(user.get("nationality"), citizenshipCode));
        }
        criteria.select(user).where(predicates.toArray(new Predicate[]{}));
        TypedQuery<User> query = em.createQuery(criteria);
        return query.getResultList();
    }
}