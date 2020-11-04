package com.bell.project.dao.nationality;

import com.bell.project.model.Nationality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class NationalityDaoImpl implements NationalityDao {

    private final EntityManager em;

    @Autowired
    public NationalityDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Nationality> nationalities() {
        TypedQuery<Nationality> query = em.createQuery("SELECT n FROM Nationality n", Nationality.class);
        return query.getResultList();
    }
}