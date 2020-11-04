package com.bell.project.controller.organization;

import com.bell.project.model.Organization;
import com.bell.project.service.organization.OrganizationService;
import com.bell.project.view.OrganizationView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OrganizationController")
@RestController
@RequestMapping(value = "/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @ApiOperation(value = "Получить организации по имени", httpMethod = "POST")
    @PostMapping("/list/{name}/{inn}/{isActive}")
    public List<OrganizationView> organization(@PathVariable(name = "name") String name,
                                               @PathVariable(name = "inn") Long inn, @PathVariable(name = "isActive") Boolean isActive) {
        return organizationService.getOrganizationByName(name, inn, isActive);
    }



}
