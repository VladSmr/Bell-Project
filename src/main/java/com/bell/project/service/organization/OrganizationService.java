package com.bell.project.service.organization;

import com.bell.project.view.organization.OrganizationView;

import java.util.List;

public interface OrganizationService {

    OrganizationView getOrganizationById(Long id);

    List<OrganizationView> getOrganizationByName(String name, Long inn, Boolean isActive);

    void addOrganization(OrganizationView organization);

    void updateOrganization(OrganizationView organization);

    List<OrganizationView> organizations();
}
