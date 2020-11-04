package com.bell.project.dao.organization;

import com.bell.project.model.Organization;

import java.util.List;

public interface OrganizationDao {

    Organization getOrganizationById(Long id);

    List<Organization> getOrganizationByName(String name, Long inn, Boolean isActive);

    void addOrganization(Organization organization);

    void updateOrganization(Organization organization);

    List<Organization> organizations();
}