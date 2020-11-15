package com.bell.project.view.organization;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description = "Организация")
public class OrganizationViewSave {

    @Size(max = 15)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Название", example = "Oracle")
    public String name;

    @Size(max = 50)
    @NotEmpty(message = "fullName cannot be null")
    @ApiModelProperty(value = "Полное название", example = "Oracle")
    public String fullName;

    @Size(min = 10, max = 10)
    @ApiModelProperty(value = "ИНН", example = "1234567890")
    public String inn;

    @Size(min = 9, max = 9)
    @ApiModelProperty(value = "КПП", example = "123456789")
    public String kpp;

    @Size(max = 50)
    @NotEmpty(message = "Address cannot be null")
    @ApiModelProperty(value = "Адрес", example = "Moscow")
    public String address;

    @Size(max = 11)
    @ApiModelProperty(value = "Номер", example = "88001112233")
    public String phone;

    @ApiModelProperty(value = "Работает", example = "TRUE")
    public Boolean isActive;

    @Override
    public String toString() {
        return "Organization: " +
                "; name = " + name +
                "; fullName = " + fullName +
                "; inn = " + inn +
                "; kpp = " + kpp +
                "; address = " + address +
                "; phone = " + phone +
                "; isActive = " + isActive;
    }
}