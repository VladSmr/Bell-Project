package com.bell.project.service.user;

import com.bell.project.dao.user.UserDao;
import com.bell.project.model.User;
import com.bell.project.model.mapper.MapperFacade;
import com.bell.project.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public UserServiceImpl(UserDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional(readOnly = true)
    public UserView getUserById(Long id) {
        User user = dao.getUserById(id);
        return mapperFacade.map(user, UserView.class);
    }

    @Override
    @Transactional
    public void addUser(UserView userView) {
        User user = new User(userView.firstName, userView.secondName, userView.middleName, userView.position, userView.phone, userView.isIdentified);
        dao.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(UserView userView) {
        User user = new User(userView.firstName, userView.secondName, userView.middleName, userView.position, userView.phone, userView.isIdentified);
        dao.updateUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserView> getUsersByOfficeId(Long id) {
        List<User> all = dao.getUsersByOfficeId(id);
        return mapperFacade.mapAsList(all, UserView.class);
    }
}