package com.bell.project.service.user;

import com.bell.project.view.user.*;

import java.util.List;

public interface UserService {

    UserView getUserById(Long id);

    void addUser(UserViewSave user);

    void updateUser(UserViewUpdate user);

    List<UserViewList> getUsersByOffice(UserFilter userFilter);
}