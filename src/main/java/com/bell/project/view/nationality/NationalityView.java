package com.bell.project.view.nationality;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

@ApiModel(description = "Гражданство")
public class NationalityView {

    @Size(max = 20)
    @ApiModelProperty(value = "Название", example = "Office")
    public String name;

    @Size(max = 3)
    @ApiModelProperty(value = "Код", example = "01")
    public String code;

    @Override
    public String toString() {
        return "Nationality: " +
                "name = " + name +
                "; code = " + code;
    }
}
