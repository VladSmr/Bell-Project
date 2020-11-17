package com.bell.project.service.organization;

import com.bell.project.dao.organization.OrganizationDao;
import com.bell.project.model.Organization;
import com.bell.project.model.mapper.MapperFacade;
import com.bell.project.view.organization.OrganizationViewSave;
import com.bell.project.view.organization.OrganizationViewShort;
import com.bell.project.view.organization.OrganizationFilter;
import com.bell.project.view.organization.OrganizationViewById;
import com.bell.project.view.organization.OrganizationViewUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public OrganizationViewById getOrganizationById(Long id) {
        Organization organization = dao.getOrganizationById(id);
        return mapperFacade.map(organization, OrganizationViewById.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<OrganizationViewShort> getOrganization(OrganizationFilter org) {
        List<Organization> organization = dao.getOrganization(org.name, org.inn, org.isActive);
        return mapperFacade.mapAsList(organization, OrganizationViewShort.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void addOrganization(OrganizationViewSave organizationViewSave) {
        dao.addOrganization(mapperFacade.map(organizationViewSave, Organization.class));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateOrganization(OrganizationViewUpdate organizationViewUpdate) {
        dao.updateOrganization(mapperFacade.map(organizationViewUpdate, Organization.class));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<OrganizationViewUpdate> organizations() {
        List<Organization> all = dao.organizations();
        return mapperFacade.mapAsList(all, OrganizationViewUpdate.class);
    }
}