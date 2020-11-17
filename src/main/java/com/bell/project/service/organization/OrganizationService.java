package com.bell.project.service.organization;

import com.bell.project.view.organization.OrganizationViewSave;
import com.bell.project.view.organization.OrganizationViewShort;
import com.bell.project.view.organization.OrganizationFilter;
import com.bell.project.view.organization.OrganizationViewById;
import com.bell.project.view.organization.OrganizationViewUpdate;

import java.util.List;

public interface OrganizationService {

    OrganizationViewById getOrganizationById(Long id);

    List<OrganizationViewShort> getOrganization(OrganizationFilter organizationFilter);

    void addOrganization(OrganizationViewSave organization);

    void updateOrganization(OrganizationViewUpdate organization);

    List<OrganizationViewUpdate> organizations();
}
