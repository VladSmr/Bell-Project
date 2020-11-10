package com.bell.project.service.office;

import com.bell.project.dao.office.OfficeDao;
import com.bell.project.model.Office;
import com.bell.project.model.mapper.MapperFacade;
import com.bell.project.view.office.OfficeView;
import com.bell.project.view.office.OfficeViewShort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OfficeServiceImpl(OfficeDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OfficeViewShort> getOffice(Long orgId, String name, String phone, Boolean isActive) {
        List<Office> offices = dao.getOffice(orgId, name, phone, isActive);
        return mapperFacade.mapAsList(offices, OfficeViewShort.class);
    }

    @Override
    @Transactional(readOnly = true)
    public OfficeView getOfficeById(Long id) {
        Office office = dao.getOfficeById(id);
        return mapperFacade.map(office, OfficeView.class);
    }

    @Override
    @Transactional
    public void addOffice(OfficeView officeView) {
        Office office = new Office(officeView.name, officeView.address, officeView.phone, officeView.isActive);
        dao.addOffice(office);
    }

    @Override
    @Transactional
    public void updateOffice(OfficeView officeView) {
        Office office = new Office(officeView.id, officeView.name, officeView.address, officeView.phone, officeView.isActive);
        dao.updateOffice(office);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OfficeView> offices() {
        List<Office> all = dao.offices();
        return mapperFacade.mapAsList(all, OfficeView.class);
    }
}