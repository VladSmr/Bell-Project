package com.bell.project.service.nationality;

import com.bell.project.view.NationalityView;

import java.util.List;

/**
 * Сервис
 */

public interface NationalityService {

    /**
     * Получить список гражданств
     *
     * @return {@Nationality}
     */
    List<NationalityView> nationalities();
}
