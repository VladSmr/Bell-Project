package com.bell.project.service.document;

import com.bell.project.dao.document.DocumentDao;
import com.bell.project.model.Document;
import com.bell.project.model.mapper.MapperFacade;
import com.bell.project.view.document.DocumentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * {@inheritDoc}
 * {@link DocumentService}
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public DocumentServiceImpl(DocumentDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DocumentView> documents() {
        List<Document> all = dao.documents();
        return mapperFacade.mapAsList(all, DocumentView.class);
    }
}