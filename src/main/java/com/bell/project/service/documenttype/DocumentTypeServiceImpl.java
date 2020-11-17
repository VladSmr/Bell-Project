package com.bell.project.service.documenttype;

import com.bell.project.dao.documenttype.DocumentTypeDao;
import com.bell.project.model.DocumentType;
import com.bell.project.model.mapper.MapperFacade;
import com.bell.project.view.documenttype.DocumentTypeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * {@inheritDoc}
 * {@link DocumentTypeService}
 */
@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {

    private final DocumentTypeDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public DocumentTypeServiceImpl(DocumentTypeDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<DocumentTypeView> documentTypes() {
        List<DocumentType> all = dao.documentTypes();
        return mapperFacade.mapAsList(all, DocumentTypeView.class);
    }
}