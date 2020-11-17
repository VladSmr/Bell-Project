package com.bell.project.dao.document;

import com.bell.project.model.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * {@inheritDoc}
 * {@link DocumentDao}
 */
@Repository
public class DocumentDaoImpl implements DocumentDao {

    private static final Logger log = LoggerFactory.getLogger(DocumentDaoImpl.class);
    private final EntityManager em;

    @Autowired
    public DocumentDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Document> documents() {
        TypedQuery<Document> query = em.createQuery("SELECT d FROM Document d", Document.class);
        List<Document> documents = query.getResultList();
        log.info(documents.toString());
        return documents;
    }
}