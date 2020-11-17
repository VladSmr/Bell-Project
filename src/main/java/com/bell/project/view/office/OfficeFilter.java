package com.bell.project.view.office;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Фильтр для сущности офис для поиска по ID организации
 */
@ApiModel(description = "Фильтр для поиска офиса")
public class OfficeFilter {

    /**
     * ID организации, которой принадлежит офис
     */
    @NotNull(message = "Organization`s ID cannot be null")
    @ApiModelProperty(value = "ID организации", example = "1")
    public Long orgId;

    /**
     * Название офиса
     */
    @Size(max = 15)
    @ApiModelProperty(value = "Название", example = "Oracle")
    public String name;

    /**
     * Номер телефона офиса
     */
    @Size(max = 11)
    @ApiModelProperty(value = "Номер", example = "88001112233")
    public String phone;

    /**
     * Активность офиса
     */
    @ApiModelProperty(value = "Работает", example = "TRUE")
    public Boolean isActive;

    @Override
    public String toString() {
        return "OfficeFilter{" +
                "orgId=" + orgId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}