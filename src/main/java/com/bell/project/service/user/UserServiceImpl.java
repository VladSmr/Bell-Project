package com.bell.project.service.user;

import com.bell.project.dao.user.UserDao;
import com.bell.project.model.User;
import com.bell.project.model.mapper.MapperFacade;
import com.bell.project.view.user.UserView;
import com.bell.project.view.user.UserViewList;
import com.bell.project.view.user.UserFilter;
import com.bell.project.view.user.UserViewUpdate;
import com.bell.project.view.user.UserViewSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * {@inheritDoc}
 * {@link UserService}
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public UserServiceImpl(UserDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public UserView getUserById(Long id) {
        return mapperFacade.map(dao.getUserById(id), UserView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void addUser(UserViewSave user) {
        dao.addUser(mapperFacade.map(user, User.class));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateUser(UserViewUpdate userView) {
        dao.updateUser(mapperFacade.map(userView, User.class));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserViewList> getUsersByOffice(UserFilter user) {
        List<User> all = dao.getUsersByOffice(user.officeId, user.firstName, user.secondName,
                user.middleName, user.position, user.documentCode, user.citizenshipCode);

        return mapperFacade.mapAsList(all, UserViewList.class);
    }
}