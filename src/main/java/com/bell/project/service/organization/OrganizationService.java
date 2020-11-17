package com.bell.project.service.organization;

import com.bell.project.view.organization.OrganizationViewSave;
import com.bell.project.view.organization.OrganizationViewShort;
import com.bell.project.view.organization.OrganizationFilter;
import com.bell.project.view.organization.OrganizationViewById;
import com.bell.project.view.organization.OrganizationViewUpdate;

import java.util.List;

/**
 * Сервис для сущности Organization
 */
public interface OrganizationService {

    /**
     * Получить организацию по ID
     *
     * @param id ID
     * @return Представление организации в OrganizationViewById
     */
    OrganizationViewById getOrganizationById(Long id);

    /**
     * Получить организацию по названию
     *
     * @param organizationFilter Представление организации в OrganizationFilter
     * @return Представление организации в OrganizationViewShort
     */
    List<OrganizationViewShort> getOrganization(OrganizationFilter organizationFilter);

    /**
     * Добавить организацию в БД
     *
     * @param organization Представление организации в OrganizationViewSave
     */
    void addOrganization(OrganizationViewSave organization);

    /**
     * Обновить организацию в БД
     *
     * @param organization Представление организации в OrganizationViewUpdate
     */
    void updateOrganization(OrganizationViewUpdate organization);

    /**
     * Получить все организации
     *
     * @return Представление организации в OrganizationViewUpdate
     */
    List<OrganizationViewUpdate> organizations();
}