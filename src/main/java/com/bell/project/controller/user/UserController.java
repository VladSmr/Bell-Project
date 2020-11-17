package com.bell.project.controller.user;

import com.bell.project.service.user.UserService;
import com.bell.project.view.user.UserView;
import com.bell.project.view.user.UserViewList;
import com.bell.project.view.user.UserFilter;
import com.bell.project.view.user.UserViewUpdate;
import com.bell.project.view.user.UserViewSave;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "UserController")
@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Получить список всех людей", httpMethod = "POST")
    @PostMapping("/list")
    public List<UserViewList> users(@Valid
                                    @RequestBody UserFilter userFilter) {
        return userService.getUsersByOffice(userFilter);
    }

    @ApiOperation(value = "Получить юзера по id", httpMethod = "GET")
    @GetMapping("/{id}")
    public UserView user(@PathVariable(name = "id") Long id) {
        return userService.getUserById(id);
    }

    @ApiOperation(value = "Обновить юзера", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/update")
    public void updateOffice(@Valid
                             @RequestBody UserViewUpdate user) {
        userService.updateUser(user);
    }

    @ApiOperation(value = "Добавить нового работника", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public void saveUser(@Valid
                         @RequestBody UserViewSave user) {
        userService.addUser(user);
    }
}