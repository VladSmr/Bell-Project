package com.bell.project.dao.documenttype;

import com.bell.project.model.DocumentType;

import java.util.List;

/**
 * ДАО сущности Document Type
 */
public interface DocumentTypeDao {

    /**
     * Получить все типы документов
     * @return List<DocumentType>
     */
    List<DocumentType> documentTypes();
}
