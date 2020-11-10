package com.bell.project.service.organization;

import com.bell.project.view.organization.OrganizationFilter;
import com.bell.project.view.organization.OrganizationView;
import com.bell.project.view.organization.OrganizationViewShort;

import java.util.List;

public interface OrganizationService {

    OrganizationView getOrganizationById(Long id);

    List<OrganizationViewShort> getOrganization(OrganizationFilter organizationFilter);

    void addOrganization(OrganizationView organization);

    void updateOrganization(OrganizationView organization);

    List<OrganizationView> organizations();
}
