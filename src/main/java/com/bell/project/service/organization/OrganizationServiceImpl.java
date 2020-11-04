package com.bell.project.service.organization;

import com.bell.project.dao.organization.OrganizationDao;
import com.bell.project.model.Organization;
import com.bell.project.model.mapper.MapperFacade;
import com.bell.project.view.OrganizationView;
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
    public OrganizationView getOrganizationById(Long id) {
        Organization organization = dao.getOrganizationById(id);
        return mapperFacade.map(organization, OrganizationView.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrganizationView> getOrganizationByName(String name, Long inn, Boolean isActive){
        List<Organization> organization = dao.getOrganizationByName(name, inn, isActive);
        return mapperFacade.mapAsList(organization, OrganizationView.class);
    }

    @Override
    @Transactional
    public void addOrganization(OrganizationView organizationView) {
        Organization organization = new Organization(organizationView.name, organizationView.fullName, organizationView.inn,
                organizationView.kpp, organizationView.address, organizationView.phone, organizationView.isActive);
        dao.addOrganization(organization);
    }

    @Override
    @Transactional
    public void updateOrganization(OrganizationView organizationView) {
        Organization organization = new Organization(organizationView.name, organizationView.fullName, organizationView.inn,
                organizationView.kpp, organizationView.address, organizationView.phone, organizationView.isActive);
        dao.updateOrganization(organization);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrganizationView> organizations() {
        List<Organization> all = dao.organizations();
        return mapperFacade.mapAsList(all, OrganizationView.class);
    }
}