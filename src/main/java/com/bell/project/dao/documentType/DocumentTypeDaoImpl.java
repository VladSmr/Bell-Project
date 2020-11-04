package com.bell.project.dao.documentType;

import com.bell.project.model.DocumentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DocumentTypeDaoImpl implements DocumentTypeDao {

    private final EntityManager em;

    @Autowired
    public DocumentTypeDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<DocumentType> documentTypes() {
        TypedQuery<DocumentType> query = em.createQuery("SELECT d FROM Document_Type d", DocumentType.class);
        return query.getResultList();
    }
}
