package com.bell.project.dao.office;

import com.bell.project.model.Office;

import java.util.List;

/**
 * ДАО сущности Office
 */
public interface OfficeDao {

    /**
     * Получить офис по ID
     *
     * @param id ID офиса
     * @return Объект класса Office
     */
    Office getOfficeById(Long id);

    /**
     * Получить офисы по ID организации
     *
     * @param orgId    ID организации
     * @param name     Название офиса
     * @param phone    Телефон офиса
     * @param isActive Активность офиса
     * @return List of Offices
     */
    List<Office> getOffice(Long orgId, String name, String phone, Boolean isActive);

    /**
     * Сохранить офис в БД
     *
     * @param office объект класса Office
     */
    void addOffice(Office office);

    /**
     * Обновить офис в БД
     *
     * @param office объект класса Office
     */
    void updateOffice(Office office);

    /**
     * Получить все офисы
     *
     * @return List of Offices
     */
    List<Office> offices();
}