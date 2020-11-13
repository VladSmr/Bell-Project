package com.bell.project.controller.documenttype;

import com.bell.project.service.documenttype.DocumentTypeService;
import com.bell.project.view.documenttype.DocumentTypeView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "DocumentTypeController")
@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class DocumentTypeController {

    private final DocumentTypeService documentTypeService;

    @Autowired
    public DocumentTypeController(DocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

    @ApiOperation(value = "Получить список всех документов", httpMethod = "GET")
    @GetMapping("/docs")
    public List<DocumentTypeView> documents() {
        return documentTypeService.documentTypes();
    }
}