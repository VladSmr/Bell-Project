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

    @ApiOperation(value = "Получить организации по имени", httpMethod = "GET")
    @PostMapping("/list/{name}/{inn}/{isActive}")
    public List<OrganizationView> organizations(@PathVariable(name = "name") String name,
                                               @PathVariable(name = "inn") Long inn, @PathVariable(name = "isActive") Boolean isActive) {
        return organizationService.getOrganizationByName(name, inn, isActive);
    }

    @ApiOperation(value = "Получить организации по ID", httpMethod = "GET")
    @PostMapping("/list/{id}")
    public OrganizationView organization(@PathVariable(name = "id") Long id) {
        return organizationService.getOrganizationById(id);
    }

    @ApiOperation(value = "Обновить организацию", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/update")
    public void updateOrganization(@RequestBody OrganizationView organization) {
        organizationService.updateOrganization(organization);
    }

    @ApiOperation(value = "Сохранить организацию", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public void saveOrganization(@RequestBody OrganizationView organization) {
        organizationService.addOrganization(organization);
    }

}