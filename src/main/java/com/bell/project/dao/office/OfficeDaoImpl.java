package com.bell.project.dao.office;

import com.bell.project.model.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
    public void addOffice(Office office) {
        em.persist(office);
    }

    @Override
    public void updateOffice(Office office) {
        em.merge(office);
    }

    @Override
    public List<Office> offices() {
        TypedQuery<Office> query = em.createQuery("SELECT o FROM Office o", Office.class);
        return query.getResultList();
    }
}