package com.bell.project.service.document;

import com.bell.project.view.document.DocumentView;


import java.util.List;

/**
 * Сервис
 */

public interface DocumentService {

    /**
     * Получить список документов
     *
     * @return {@Document}
     */
    List<DocumentView> documents();
}
