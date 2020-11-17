package com.bell.project.service.office;

import com.bell.project.dao.office.OfficeDao;
import com.bell.project.model.Office;
import com.bell.project.model.mapper.MapperFacade;
import com.bell.project.view.office.OfficeView;
import com.bell.project.view.office.OfficeViewGetById;
import com.bell.project.view.office.OfficeViewShort;
import com.bell.project.view.office.OfficeFilter;
import com.bell.project.view.office.OfficeViewSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * {@inheritDoc}
 * {@link OfficeService}
 */
@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OfficeServiceImpl(OfficeDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<OfficeViewShort> getOffice(OfficeFilter office) {
        List<Office> offices = dao.getOffice(office.orgId, office.name, office.phone, office.isActive);
        return mapperFacade.mapAsList(offices, OfficeViewShort.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public OfficeViewGetById getOfficeById(Long id) {
        Office office = dao.getOfficeById(id);
        return mapperFacade.map(office, OfficeViewGetById.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void addOffice(OfficeViewSave officeView) {
        dao.addOffice(mapperFacade.map(officeView, Office.class));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateOffice(OfficeView officeView) {
        dao.updateOffice(mapperFacade.map(officeView, Office.class));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<OfficeView> offices() {
        List<Office> all = dao.offices();
        return mapperFacade.mapAsList(all, OfficeView.class);
    }
}