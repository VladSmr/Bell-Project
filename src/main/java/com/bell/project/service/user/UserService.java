package com.bell.project.service.user;

import com.bell.project.view.user.UserView;
import com.bell.project.view.user.UserViewList;
import com.bell.project.view.user.UserFilter;
import com.bell.project.view.user.UserViewUpdate;
import com.bell.project.view.user.UserViewSave;

import java.util.List;

/**
 * Сервис для сущности User
 */
public interface UserService {

    /**
     * Получить юзера по ID
     *
     * @param id ID юзера
     * @return Представление юзера в UserView
     */
    UserView getUserById(Long id);

    /**
     * Добавить юзера в БД
     *
     * @param user Представление юзера в UserViewSave
     */
    void addUser(UserViewSave user);

    /**
     * Обновить юзера в БД
     *
     * @param user Представление юзера в UserViewUpdate
     */
    void updateUser(UserViewUpdate user);

    /**
     * Получить юзеров по ID офиса
     *
     * @param userFilter Представление юзера в UserFilter
     * @return Представление юзеров в UserViewList
     */
    List<UserViewList> getUsersByOffice(UserFilter userFilter);
}