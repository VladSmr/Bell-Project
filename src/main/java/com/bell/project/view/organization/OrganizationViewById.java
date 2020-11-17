package com.bell.project.view.organization;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

/**
 * Представление организация для поиска по ID организации
 */
@ApiModel(description = "Организация для ID")
public class OrganizationViewById {

    /**
     * ID
     */
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public String id;

    /**
     * Название организации
     */
    @Size(max = 15)
    @ApiModelProperty(value = "Название", example = "Oracle")
    public String name;

    /**
     * Полное название организации
     */
    @Size(max = 50)
    @ApiModelProperty(value = "Полное название", example = "Oracle")
    public String fullName;

    /**
     * ИНН организации
     */
    @Size(min = 10, max = 10)
    @ApiModelProperty(value = "ИНН", example = "1234567890")
    public String inn;

    /**
     * КПП организации
     */
    @Size(min = 9, max = 9)
    @ApiModelProperty(value = "КПП", example = "123456789")
    public String kpp;

    /**
     * Адрес организации
     */
    @Size(max = 50)
    @ApiModelProperty(value = "Адрес", example = "Moscow")
    public String address;

    /**
     * Номер телефона организации
     */
    @Size(max = 11)
    @ApiModelProperty(value = "Номер", example = "88001112233")
    public String phone;

    /**
     * Активность организации
     */
    @ApiModelProperty(value = "Работает", example = "TRUE")
    public Boolean isActive;

    @Override
    public String toString() {
        return "Organization: " +
                "id = " + id +
                "; name = " + name +
                "; fullName = " + fullName +
                "; inn = " + inn +
                "; kpp = " + kpp +
                "; address = " + address +
                "; phone = " + phone +
                "; isActive = " + isActive;
    }
}
