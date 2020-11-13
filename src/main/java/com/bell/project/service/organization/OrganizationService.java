package com.bell.project.service.organization;

import com.bell.project.view.organization.*;

import java.util.List;

public interface OrganizationService {

    OrganizationViewById getOrganizationById(Long id);

    List<OrganizationViewShort> getOrganization(OrganizationFilter organizationFilter);

    void addOrganization(OrganizationViewSave organization);

    void updateOrganization(OrganizationViewUpdate organization);

    List<OrganizationViewUpdate> organizations();
}
