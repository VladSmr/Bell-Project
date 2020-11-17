package com.bell.project.service.nationality;

import com.bell.project.view.nationality.NationalityView;

import java.util.List;

/**
 * Сервис для сущности Nationality
 */
public interface NationalityService {

    /**
     * Получить список гражданств
     *
     * @return {@Nationality}
     */
    List<NationalityView> nationalities();
}
