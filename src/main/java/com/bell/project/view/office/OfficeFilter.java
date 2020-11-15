package com.bell.project.view.office;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description = "Фильтр для поиска офиса")
public class OfficeFilter {

    @NotNull(message = "Organization`s ID cannot be null")
    @ApiModelProperty(value = "ID организации", example = "1")
    public Long orgId;

    @Size(max = 15)
    @ApiModelProperty(value = "Название", example = "Oracle")
    public String name;

    @Size(max = 11)
    @ApiModelProperty(value = "Номер", example = "88001112233")
    public String phone;

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