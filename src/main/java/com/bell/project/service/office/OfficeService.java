package com.bell.project.service.office;

import com.bell.project.view.OfficeView;

import java.util.List;

public interface OfficeService {

    OfficeView getOfficeById(Long id);

    void addOffice(OfficeView office);

    void updateOffice(OfficeView office);

    List<OfficeView> offices();
}
