package com.bell.project.service.documentType;

import com.bell.project.dao.documentType.DocumentTypeDao;
import com.bell.project.model.DocumentType;
import com.bell.project.model.mapper.MapperFacade;
import com.bell.project.view.DocumentTypeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {

    private final DocumentTypeDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public DocumentTypeServiceImpl(DocumentTypeDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    public List<DocumentTypeView> documentTypes() {
        List<DocumentType> all = dao.documentTypes();
        return mapperFacade.mapAsList(all, DocumentTypeView.class);
    }
}
