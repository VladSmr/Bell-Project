package com.bell.project.service.documenttype;

import com.bell.project.view.documenttype.DocumentTypeView;

import java.util.List;

/**
 * Сервис для сущности DocumentType
 */
public interface DocumentTypeService {

    /**
     * Получить список типов документов
     *
     * @return List of DocumentTypeView
     */
    List<DocumentTypeView> documentTypes();
}
