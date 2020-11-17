package com.bell.project.view.organization;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Фильтр для поиска сущности организация по ID, ИНН, активности
 */
@ApiModel(description = "Фильтр для поиска организации")
public class OrganizationFilter {

    /**
     * Название организации
     */
    @Size(max = 15)
    @NotBlank(message = "name cannot be null")
    @ApiModelProperty(value = "Название", example = "Oracle")
    public String name;

    /**
     * ИНН организации
     */
    @Size(min = 10, max = 10)
    @ApiModelProperty(value = "ИНН", example = "1234567890")
    public String inn;

    /**
     * Активность организации
     */
    @ApiModelProperty(value = "Работает", example = "TRUE")
    public Boolean isActive;

    @Override
    public String toString() {
        return "OrganizationViewShort{" +
                "name='" + name + '\'' +
                ", inn=" + inn +
                ", isActive=" + isActive +
                '}';
    }
}