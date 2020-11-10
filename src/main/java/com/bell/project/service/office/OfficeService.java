package com.bell.project.service.office;

import com.bell.project.view.office.*;

import java.util.List;

public interface OfficeService {

    OfficeViewGetById getOfficeById(Long id);

    List<OfficeViewShort> getOffice(OfficeFilter officeFilter);

    void addOffice(OfficeViewSave office);

    void updateOffice(OfficeView office);

    List<OfficeView> offices();
}
