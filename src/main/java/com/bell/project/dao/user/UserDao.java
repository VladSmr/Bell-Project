package com.bell.project.dao.user;

import com.bell.project.model.User;

import java.util.List;

/**
 * ДАО сущности User
 */
public interface UserDao {

    /**
     * Получить юзера по ID
     *
     * @param id ID юзера
     * @return Объект класса User
     */
    User getUserById(Long id);

    /**
     * Добавить юзера в БД
     *
     * @param user Объект класса User
     */
    void addUser(User user);

    /**
     * Обновить юзера в БД
     *
     * @param user Объект класса User
     */
    void updateUser(User user);

    /**
     * Получить юзеров по ID офиса
     *
     * @param officeId        ID офиса
     * @param name            Имя юзера
     * @param lastName        Фамилия юзера
     * @param middleName      Отчество юзера
     * @param position        Должность юзера
     * @param docCode         Код типа документа юзера
     * @param citizenshipCode Код страны юзера
     * @return List<User>
     */
    List<User> getUsersByOffice(Long officeId, String name, String lastName, String middleName,
                                String position, String docCode, String citizenshipCode);
}
