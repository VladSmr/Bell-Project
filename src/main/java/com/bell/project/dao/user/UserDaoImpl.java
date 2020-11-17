package com.bell.project.dao.user;

import com.bell.project.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

    private final EntityManager em;

    @Autowired
    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public User getUserById(Long id) {
        User user = em.find(User.class, id);
        if (user == null) {
            log.warn("user with ID " + " not found");
            throw new EntityNotFoundException();
        }
        return user;
    }

    @Override
    public void addUser(User user) {
        if (user.getNationality() != null) {
            TypedQuery<Nationality> query = em.createQuery("SELECT n FROM Nationality n WHERE n.code = ?1", Nationality.class);
            query.setParameter(1, user.getNationality().getCode());
            try {
                log.info("Поиск страны по коду " + user.getNationality().getCode());
                user.setNationality(query.getSingleResult());
                log.info("User: " + user.toString());
            } catch (NoResultException e) {
                log.warn("Nationality with code " + user.getNationality().getCode() + " not found");
                throw new RuntimeException("Nationality with provided code not found. Check the code and try again", e);
            }
        }

        log.info("Поиск офиса с ID " + user.getOffice().getId());
        Office of = em.getReference(Office.class, user.getOffice().getId());
        user.setOffice(of);
        log.info("User: " + user.toString());

        if (user.getDocument().getDocumentType().getCode() != null) {
            TypedQuery<DocumentType> query2 = em.createQuery("SELECT d FROM DocumentType d WHERE d.code = ?1", DocumentType.class);
            query2.setParameter(1, user.getDocument().getDocumentType().getCode());
            DocumentType docT;
            try {
                log.info("Поиск типа документа по коду " + user.getDocument().getDocumentType().getCode());
                docT = query2.getSingleResult();
                user.getDocument().setDocumentType(docT);
                log.info("User: " + user.toString());
            } catch (NoResultException e) {
                log.warn("Document with code " + user.getDocument().getDocumentType().getCode() + " not found");
                throw new RuntimeException("Document with provided code not found. Check the code and try again", e);
            }
        }
        log.info("User: " + user.toString());
        Document doc = user.getDocument();
        user.setDocument(null);
        log.info("User after setDocument(null): " + user.toString());
        em.persist(user);

        user.setDocument(doc);
        doc.setUser(user);
        log.info("User after setDocument: " + user.toString());
        em.persist(user.getDocument());
    }

    @Override
    public void updateUser(User user) {
        User us = em.find(User.class, user.getId());
        if (us == null) {
            log.warn("user with ID " + user.getId() + " not found");
            throw new EntityNotFoundException("User with provided ID not found");
        } else {
            Office of = em.getReference(Office.class, user.getOffice().getId());
            log.info("Office with ID: " + user.getOffice().getId() + " - " + of.toString());
            us.setOffice(of);
            log.info("User after setOffice: " + us.toString());

            us.setFirstName(user.getFirstName());
            us.setSecondName(user.getSecondName());
            us.setMiddleName(user.getMiddleName());
            us.setPosition(user.getPosition());
            us.setPhone(user.getPhone());
            us.getDocument().setNumber(user.getDocument().getNumber());
            us.getDocument().setDate(user.getDocument().getDate());
            log.info("User: " + us.toString());

            TypedQuery<DocumentType> query = em.createQuery("SELECT d FROM DocumentType d WHERE d.name = ?1", DocumentType.class);
            query.setParameter(1, user.getDocument().getDocumentType().getName());
            DocumentType docT;
            try {
                log.info("Looking for document type with name: " + user.getDocument().getDocumentType().getName());
                docT = query.getSingleResult();
                us.getDocument().setDocumentType(docT);
                log.info("Document type found. User: " + us.toString());
            } catch (NoResultException e) {
                log.warn("Document type not found. Name: " + user.getDocument().getDocumentType().getName());
                throw new RuntimeException("DocumentType with provided name not found. Check the name and try again", e);
            }

            TypedQuery<Nationality> query2 = em.createQuery("SELECT n FROM Nationality n WHERE n.code = ?1", Nationality.class);
            query2.setParameter(1, user.getNationality().getCode());
            Nationality nat = query2.getSingleResult();
            if (nat != null) {
                log.info("Nationality with code " + user.getNationality().getCode() + " is: " + nat.toString());
                try {
                    us.setNationality(nat);
                    log.info("User: " + us.toString());
                } catch (NoResultException e) {
                    log.warn("No result setting nationality: " + nat.toString());
                    throw new RuntimeException("Nationality with provided code not found. Check the code and try again", e);
                }
            }
            us.setIsIdentified(user.getIsIdentified());
            log.info("User: " + us.toString());
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
        List<User> userList = query.getResultList();
        if (userList.isEmpty()) {
            log.warn("Users not found");
            throw new EntityNotFoundException();
        } else {
            log.info("Users: " + userList.toString());
            return userList;
        }
    }
}