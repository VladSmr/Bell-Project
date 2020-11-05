package com.bell.project.view.organization;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description = "Организация (short version)")
public class OrganizationViewShort {

    @Size(max = 15)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Название", example = "Oracle")
    public String name;

    @Size(max = 10)
    @ApiModelProperty(value = "ИНН", example = "1234567890")
    public Long inn;

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