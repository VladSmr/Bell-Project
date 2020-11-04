package com.bell.project.service.documentType;

import com.bell.project.view.DocumentTypeView;

import java.util.List;

public interface DocumentTypeService {

    /**
     * Получить список документов
     *
     * @return {@Document}
     */
    List<DocumentTypeView> documentTypes();
}
