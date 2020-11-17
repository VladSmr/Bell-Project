package com.bell.project.dao.documenttype;

import com.bell.project.model.DocumentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DocumentTypeDaoImpl implements DocumentTypeDao {

    private static final Logger log = LoggerFactory.getLogger(DocumentTypeDaoImpl.class);
    private final EntityManager em;

    @Autowired
    public DocumentTypeDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<DocumentType> documentTypes() {
        TypedQuery<DocumentType> query = em.createQuery("SELECT d FROM DocumentType d", DocumentType.class);
        List<DocumentType> documentTypes = query.getResultList();
        log.info(documentTypes.toString());
        return documentTypes;
    }
}