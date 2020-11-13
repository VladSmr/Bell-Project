package com.bell.project.dao.office;

import com.bell.project.model.Office;
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
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Office getOfficeById(Long id) {
        return em.find(Office.class, id);
    }

    @Override
    public List<Office> getOffice(Long orgId, String name, String phone, Boolean isActive) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Office> criteria = builder.createQuery(Office.class);
        Root<Office> office = criteria.from(Office.class);
        List<Predicate> predicates = new ArrayList<>();

        if (orgId != null) {
            predicates.add(builder.equal(office.get("organization"), orgId));
        }
        if (name != null) {
            predicates.add(builder.equal(office.get("name"), name));
        }
        if (phone != null) {
            predicates.add(builder.equal(office.get("phone"), phone));
        }
        if (isActive != null) {
            predicates.add(builder.equal(office.get("isActive"), isActive));
        }
        criteria.select(office).where(predicates.toArray(new Predicate[]{}));
        TypedQuery<Office> query = em.createQuery(criteria);
        return query.getResultList();
    }

    @Override
    public void addOffice(Office office) {
        em.persist(office);
    }

    @Override
    public void updateOffice(Office office) {
        Office of = em.find(Office.class, office.getId());
        if (of == null) {
            throw new EntityNotFoundException("Office with provided ID not found");
        } else {
            of.setId(office.getId());
            of.setName(office.getName());
            of.setAddress(office.getAddress());
            of.setPhone(office.getPhone());
            of.setIsActive(office.getIsActive());
        }
    }

    @Override
    public List<Office> offices() {
        TypedQuery<Office> query = em.createQuery("SELECT o FROM Office o", Office.class);
        return query.getResultList();
    }
}