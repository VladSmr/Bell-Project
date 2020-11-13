package com.bell.project.dao.user;

import com.bell.project.model.User;

import java.util.List;

public interface UserDao {

    User getUserById(Long id);

    void addUser(User user);

    void updateUser(User user);

    List<User> getUsersByOffice(Long officeId, String name, String lastName, String middleName,
                                String position, String docCode, String citizenshipCode);
}
