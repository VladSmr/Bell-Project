package com.bell.project.service.office;

import com.bell.project.view.office.OfficeView;
import com.bell.project.view.office.OfficeViewGetById;
import com.bell.project.view.office.OfficeViewShort;
import com.bell.project.view.office.OfficeFilter;
import com.bell.project.view.office.OfficeViewSave;

import java.util.List;

/**
 * Сервис для сущности Office
 */
public interface OfficeService {

    /**
     * Получить офис по ID
     *
     * @param id ID
     * @return Представление оффиса в OfficeViewGetById
     */
    OfficeViewGetById getOfficeById(Long id);

    /**
     * Получить все офисы по ID организации
     *
     * @param officeFilter Представление оффиса в OfficeFilter
     * @return Представление оффиса в OfficeViewShort
     */
    List<OfficeViewShort> getOffice(OfficeFilter officeFilter);

    /**
     * Добавить офис в БД
     *
     * @param office Представление оффиса в OfficeViewSave
     */
    void addOffice(OfficeViewSave office);

    /**
     * Обновить офис в БД
     *
     * @param office Представление оффиса в OfficeView
     */
    void updateOffice(OfficeView office);

    /**
     * Получить все оффисы
     *
     * @return Представление оффиса в OfficeView
     */
    List<OfficeView> offices();
}