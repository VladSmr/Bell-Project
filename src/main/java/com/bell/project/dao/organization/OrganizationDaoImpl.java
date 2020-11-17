package com.bell.project.dao.organization;

import com.bell.project.model.Organization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private static final Logger log = LoggerFactory.getLogger(OrganizationDaoImpl.class);
    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organization getOrganizationById(Long id) {
        Organization organization = em.find(Organization.class, id);
        if (organization == null) {
            log.warn("Organization not found. ID: " + id);
            throw new EntityNotFoundException();
        } else {
            return organization;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Organization> getOrganization(String name, String inn, Boolean isActive) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteria = builder.createQuery(Organization.class);
        Root<Organization> organization = criteria.from(Organization.class);
        List<Predicate> predicates = new ArrayList<>();

        if (name != null) {
            predicates.add(builder.equal(organization.get("name"), name));
        }
        if (inn != null) {
            predicates.add(builder.equal(organization.get("inn"), inn));
        }
        if (isActive != null) {
            predicates.add(builder.equal(organization.get("isActive"), isActive));
        }
        criteria.select(organization).where(predicates.toArray(new Predicate[]{}));
        TypedQuery<Organization> query = em.createQuery(criteria);
        List<Organization> organizations = query.getResultList();
        if (organizations.isEmpty()) {
            log.warn("Organizations not found");
            throw new EntityNotFoundException();
        } else {
            return organizations;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addOrganization(Organization organization) {
        log.info("Organization: " + organization.toString());
        em.persist(organization);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateOrganization(Organization organization) {
        Organization org = em.find(Organization.class, organization.getId());
        if (org == null) {
            log.warn("Organization not found. ID: " + organization.getId());
            throw new EntityNotFoundException();
        } else {
            org.setId(organization.getId());
            org.setName(organization.getName());
            org.setFullName(organization.getFullName());
            org.setInn(organization.getInn());
            org.setKpp(organization.getKpp());
            org.setAddress(organization.getAddress());
            org.setPhone(organization.getPhone());
            org.setIsActive(organization.getIsActive());
            log.info("Organization updated. Organization: " + org.toString());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Organization> organizations() {
        TypedQuery<Organization> query = em.createQuery("SELECT o FROM Organization o", Organization.class);
        return query.getResultList();
    }
}