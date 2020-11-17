package com.bell.project.dao.nationality;

import com.bell.project.model.Nationality;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class NationalityDaoImpl implements NationalityDao {

    private static final Logger log = LoggerFactory.getLogger(NationalityDaoImpl.class);
    private final EntityManager em;

    @Autowired
    public NationalityDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Nationality> nationalities() {
        TypedQuery<Nationality> query = em.createQuery("SELECT n FROM Nationality n", Nationality.class);
        List<Nationality> nationalities = query.getResultList();
        log.info(nationalities.toString());
        return nationalities;
    }
}