package com.bell.project.controller.nationality;

import com.bell.project.service.nationality.NationalityService;
import com.bell.project.view.nationality.NationalityView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "NationalityController")
@RestController
@RequestMapping(value = "/countries", produces = APPLICATION_JSON_VALUE)
public class NationalityController {

    private final NationalityService nationalityService;

    @Autowired
    public NationalityController(NationalityService nationalityService) {
        this.nationalityService = nationalityService;
    }

    @ApiOperation(value = "Получить список всех стран", httpMethod = "GET")
    @GetMapping("/")
    public List<NationalityView> nationalities() {
        return nationalityService.nationalities();
    }
}