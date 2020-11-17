package com.bell.project.view.office;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Представление сущности офиса для сохранения
 */
@ApiModel(description = "Офис для сохранения")
public class OfficeViewSave {

    /**
     * ID организации, которой принадлежит офис
     */
    @NotNull
    @ApiModelProperty(value = "Уникальный идентификатор организации", hidden = true, example = "1")
    public Long orgId;

    /**
     * Название офиса
     */
    @Size(max = 15)
    @ApiModelProperty(value = "Название", example = "Office")
    public String name;

    /**
     * Адрес офиса
     */
    @Size(max = 50)
    @ApiModelProperty(value = "Адрес", example = "Moscow")
    public String address;

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
        return "Office: " +
                "orgId = " + orgId +
                "; name = " + name +
                "; address = " + address +
                "; phone = " + phone +
                "; isActive = " + isActive;
    }
}