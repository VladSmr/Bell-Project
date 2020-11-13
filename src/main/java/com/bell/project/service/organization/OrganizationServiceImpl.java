package com.bell.project.service.organization;

import com.bell.project.dao.organization.OrganizationDao;
import com.bell.project.model.Organization;
import com.bell.project.model.mapper.MapperFacade;
import com.bell.project.view.organization.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional(readOnly = true)
    public OrganizationViewById getOrganizationById(Long id) {
        Organization organization = dao.getOrganizationById(id);
        return mapperFacade.map(organization, OrganizationViewById.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrganizationViewShort> getOrganization(OrganizationFilter org){
        List<Organization> organization = dao.getOrganization(org.name, org.inn, org.isActive);
        return mapperFacade.mapAsList(organization, OrganizationViewShort.class);
    }

    @Override
    @Transactional
    public void addOrganization(OrganizationViewSave organizationViewSave) {
        dao.addOrganization(mapperFacade.map(organizationViewSave, Organization.class));
    }

    @Override
    @Transactional
    public void updateOrganization(OrganizationViewUpdate organizationViewUpdate) {
        dao.updateOrganization(mapperFacade.map(organizationViewUpdate, Organization.class));
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrganizationViewUpdate> organizations() {
        List<Organization> all = dao.organizations();
        return mapperFacade.mapAsList(all, OrganizationViewUpdate.class);
    }
}