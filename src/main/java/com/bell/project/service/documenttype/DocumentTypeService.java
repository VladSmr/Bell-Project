package com.bell.project.service.documenttype;

import com.bell.project.view.documenttype.DocumentTypeView;

import java.util.List;

public interface DocumentTypeService {

    /**
     * Получить список документов
     *
     * @return {@Document}
     */
    List<DocumentTypeView> documentTypes();
}
