package com.bell.project.dao.user;

import com.bell.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
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
        em.persist(user);
    }

    @Override
    public void updateUser(User user) {
        User us = em.find(User.class, user.getId());
        if (us == null) {
            throw new EntityNotFoundException("User with provided ID not found");
        } else {
            us.setFirstName(user.getFirstName());
            us.setOffice(user.getOffice());
            us.setFirstName(user.getFirstName());
            us.setSecondName(user.getSecondName());
            us.setMiddleName(user.getMiddleName());
            us.setPosition(user.getPosition());
            us.setPhone(user.getPhone());
            us.setDocument(user.getDocument());  // ???
            us.setNationality(user.getNationality());  // ???
            us.setIdentified(user.isIdentified());
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
            predicates.add(builder.equal(user.get("office_id"), officeId));
        }
        if (name != null) {
            predicates.add(builder.equal(user.get("first_name"), name));
        }
        if (lastName != null) {
            predicates.add(builder.equal(user.get("last_name"), lastName));
        }
        if (middleName != null) {
            predicates.add(builder.equal(user.get("middle_name"), middleName));
        }
        if (position != null) {
            predicates.add(builder.equal(user.get("position"), position));
        }
/*        if (docCode != null) {
            predicates.add(builder.equal(user.get("document"), docCode));
        }
        if (citizenshipCode != null) {
            predicates.add(builder.equal(user.get("citizenship"), citizenshipCode));
        }*/
        criteria.select(user).where(predicates.toArray(new Predicate[]{}));
        TypedQuery<User> query = em.createQuery(criteria);
        return query.getResultList();
    }
}