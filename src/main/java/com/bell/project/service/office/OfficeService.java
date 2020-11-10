package com.bell.project.service.office;

import com.bell.project.view.office.OfficeView;
import com.bell.project.view.office.OfficeViewShort;

import java.util.List;

public interface OfficeService {

    OfficeView getOfficeById(Long id);

    List<OfficeViewShort> getOffice(Long orgId, String name, String phone, Boolean isActive);

    void addOffice(OfficeView office);

    void updateOffice(OfficeView office);

    List<OfficeView> offices();
}
