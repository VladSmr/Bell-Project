package com.bell.project.controller.organization;

import com.bell.project.service.organization.OrganizationService;
import com.bell.project.view.organization.OrganizationViewSave;
import com.bell.project.view.organization.OrganizationViewShort;
import com.bell.project.view.organization.OrganizationFilter;
import com.bell.project.view.organization.OrganizationViewById;
import com.bell.project.view.organization.OrganizationViewUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OrganizationController")
@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @ApiOperation(value = "Получить организации по имени", httpMethod = "POST")
    @PostMapping("/list")
    public List<OrganizationViewShort> organizations(@Valid
                                                     @RequestBody OrganizationFilter organization) {
        return organizationService.getOrganization(organization);
    }

    @ApiOperation(value = "Получить организации по ID", httpMethod = "GET")
    @GetMapping("/{id}")
    public OrganizationViewById organization(@PathVariable(name = "id") Long id) {
        return organizationService.getOrganizationById(id);
    }

    @ApiOperation(value = "Обновить организацию", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/update")
    public void updateOrganization(@Valid
                                   @RequestBody OrganizationViewUpdate organization) {
        organizationService.updateOrganization(organization);
    }

    @ApiOperation(value = "Сохранить организацию", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public void saveOrganization(@Valid
                                 @RequestBody OrganizationViewSave organization) {
        organizationService.addOrganization(organization);
    }
}