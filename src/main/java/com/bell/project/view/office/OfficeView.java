package com.bell.project.view.office;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description = "Офис")
public class OfficeView extends OfficeFilter {

    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Long id;

    @Size(max = 15)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Название", example = "Office")
    public String name;

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
        return "Office: " +
                "id = " + id +
                "; name = " + name +
                "; address = " + address +
                "; phone = " + phone +
                "; isActive = " + isActive;
    }
}