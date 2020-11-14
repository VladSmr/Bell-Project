package com.bell.project.controller.office;

import com.bell.project.service.office.OfficeService;
import com.bell.project.view.office.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OfficeController")
@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @ApiOperation(value = "Получить офисы по ID организации", httpMethod = "POST")
    @PostMapping("/list")
    public List<OfficeViewShort> offices(@Valid
                                         @RequestBody OfficeFilter office) {
        return officeService.getOffice(office);
    }

    @ApiOperation(value = "Получить офис по ID", httpMethod = "GET")
    @GetMapping("/{id}")
    public OfficeViewGetById office(@PathVariable(name = "id") Long id) {
        return officeService.getOfficeById(id);
    }

    @ApiOperation(value = "Обновить офис", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/update")
    public void updateOffice(@Valid
                             @RequestBody OfficeView office) {
        officeService.updateOffice(office);
    }

    @ApiOperation(value = "Сохранить офис", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public void saveOffice(@Valid
                           @RequestBody OfficeViewSave office) {
        officeService.addOffice(office);
    }
}