package com.bell.project.dao.document;

import com.bell.project.model.Document;

import java.util.List;

/**
 * ДАО сущности Document
 */
public interface DocumentDao {

    /**
     * Получить все документы
     * @return List<Document>
     */
    List<Document> documents();
}
