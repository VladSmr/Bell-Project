package com.bell.project.view.office;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

@ApiModel(description = "Офис по ID")
public class OfficeViewGetById {

    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Long id;

    @Size(max = 15)
    @ApiModelProperty(value = "Название", example = "Office")
    public String name;

    @Size(max = 50)
    @ApiModelProperty(value = "Адрес", example = "Moscow")
    public String address;

    @Size(max = 11)
    @ApiModelProperty(value = "Номер", example = "88001112233")
    public String phone;

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
