package com.bell.project.dao.office;

import com.bell.project.model.Office;

import java.util.List;

public interface OfficeDao {

    Office getOfficeById(Long id);

    void addOffice(Office office);

    void updateOffice(Office office);

    List<Office> offices();
}
