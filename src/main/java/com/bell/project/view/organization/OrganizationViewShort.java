package com.bell.project.view.organization;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Представление организация
 */
@ApiModel(description = "Организация (короткая версия)")
public class OrganizationViewShort {

    /**
     * ID
     */
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public String id;

    /**
     * Название организации
     */
    @Size(max = 15)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Название", example = "Oracle")
    public String name;

    /**
     * Активность организации
     */
    @ApiModelProperty(value = "Работает", example = "TRUE")
    public Boolean isActive;

    @Override
    public String toString() {
        return "OrganizationViewShort{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}