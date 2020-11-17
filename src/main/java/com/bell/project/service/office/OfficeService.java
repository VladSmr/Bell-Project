package com.bell.project.service.office;

import com.bell.project.view.office.OfficeView;
import com.bell.project.view.office.OfficeViewGetById;
import com.bell.project.view.office.OfficeViewShort;
import com.bell.project.view.office.OfficeFilter;
import com.bell.project.view.office.OfficeViewSave;

import java.util.List;

public interface OfficeService {

    OfficeViewGetById getOfficeById(Long id);

    List<OfficeViewShort> getOffice(OfficeFilter officeFilter);

    void addOffice(OfficeViewSave office);

    void updateOffice(OfficeView office);

    List<OfficeView> offices();
}
