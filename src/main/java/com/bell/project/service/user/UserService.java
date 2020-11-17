package com.bell.project.service.user;

import com.bell.project.view.user.UserView;
import com.bell.project.view.user.UserViewList;
import com.bell.project.view.user.UserFilter;
import com.bell.project.view.user.UserViewUpdate;
import com.bell.project.view.user.UserViewSave;

import java.util.List;

public interface UserService {

    UserView getUserById(Long id);

    void addUser(UserViewSave user);

    void updateUser(UserViewUpdate user);

    List<UserViewList> getUsersByOffice(UserFilter userFilter);
}