package com.bell.project.dao.nationality;

import com.bell.project.model.Nationality;

import java.util.List;

/**
 * ДАО сущности Nationality
 */
public interface NationalityDao {

    /**
     * Получить все страны
     * @return List of Nationalities
     */
    List<Nationality> nationalities();
}
