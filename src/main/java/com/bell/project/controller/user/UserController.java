package com.bell.project.controller.user;

import com.bell.project.service.user.UserService;
import com.bell.project.view.UserView;
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

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "PersonController")
@RestController
@RequestMapping(value = "/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Добавить нового работника", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public void person(@RequestBody UserView user) {
        userService.addUser(user);
    }

    @ApiOperation(value = "Получить список всех людей", httpMethod = "GET")
    @GetMapping("/list/{id}")
    public List<UserView> persons(@PathVariable(name = "id") Long id) {
        return userService.getUsersByOfficeId(id);
    }

    @ApiOperation(value = "Получить юзера по id", httpMethod = "GET")
    @GetMapping("/{id}")
    public UserView user(@PathVariable(name = "id") Long id) {
        return userService.getUserById(id);
    }

    @ApiOperation(value = "Редактировать юзера по id", httpMethod = "POST")
    @RequestMapping(value = "/edit/{id}")
    public void editUser(@PathVariable(name = "id") Long id) {
        userService.updateUser(userService.getUserById(id));
    }
}