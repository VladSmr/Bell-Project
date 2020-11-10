package com.bell.project.dao.organization;

import com.bell.project.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Organization getOrganizationById(Long id) {
        return em.find(Organization.class, id);
    }

    @Override
    public List<Organization> getOrganization(String name, Long inn, Boolean isActive) {
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
        return query.getResultList();
    }

    @Override
    public void addOrganization(Organization organization) {
        em.persist(organization);
    }

    @Override
    public void updateOrganization(Organization organization) {
        Organization org = em.find(Organization.class, organization.getId());
        org.setId(organization.getId());
        org.setName(organization.getName());
        org.setFullName(organization.getFullName());
        org.setInn(organization.getInn());
        org.setKpp(organization.getKpp());
        org.setAddress(organization.getAddress());
        org.setPhone(organization.getPhone());
        org.setActive(organization.isActive());
    }

    @Override
    public List<Organization> organizations() {
        TypedQuery<Organization> query = em.createQuery("SELECT o FROM Organization o", Organization.class);
        return query.getResultList();
    }
}