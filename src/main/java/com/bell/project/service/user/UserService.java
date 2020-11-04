package com.bell.project.service.user;

import com.bell.project.view.UserView;

import java.util.List;

public interface UserService {

    UserView getUserById(Long id);

    void addUser(UserView user);

    void updateUser(UserView user);

    List<UserView> getUsersByOfficeId(Long id);
}
