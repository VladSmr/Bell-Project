package com.bell.project.dao.organization;

import com.bell.project.model.Organization;

import java.util.List;

/**
 * ДАО сущности Organization
 */
public interface OrganizationDao {

    /**
     * Получить организацию по ID
     *
     * @param id ID организации
     * @return Объект класса Organization
     */
    Organization getOrganizationById(Long id);

    /**
     * Получить организации по названию
     *
     * @param name     Название
     * @param inn      ИНН
     * @param isActive Активность
     * @return List of Organizations
     */
    List<Organization> getOrganization(String name, String inn, Boolean isActive);

    /**
     * Сохранить организацию в БД
     *
     * @param organization Объект класса Organization
     */
    void addOrganization(Organization organization);

    /**
     * Обновить организацию в БД
     *
     * @param organization Объект класса Organization
     */
    void updateOrganization(Organization organization);

    /**
     * Получить все организации
     *
     * @return List of Organizations
     */
    List<Organization> organizations();
}