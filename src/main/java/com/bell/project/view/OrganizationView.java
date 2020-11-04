package com.bell.project.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description = "Организация")
public class OrganizationView {

    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public String id;

    @Size(max = 15)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Название", example = "Oracle")
    public String name;

    @Size(max = 50)
    @NotEmpty(message = "fullName cannot be null")
    @ApiModelProperty(value = "Полное название", example = "Oracle")
    public String fullName;

    @Size(max = 10)
    @NotEmpty(message = "inn cannot be null")
    @ApiModelProperty(value = "ИНН", example = "1234567890")
    public Long inn;

    @Size(max = 9)
    @NotEmpty(message = "kpp cannot be null")
    @ApiModelProperty(value = "КПП", example = "123456789")
    public Long kpp;

    @Size(max = 50)
    @NotEmpty(message = "Address cannot be null")
    @ApiModelProperty(value = "Адрес", example = "Moscow")
    public String address;

    @Size(max = 11)
    @NotNull(message = "Phone number cannot be null")
    @ApiModelProperty(value = "Номер", example = "88001112233")
    public String phone;

    @NotNull(message = "Active cannot be null")
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
