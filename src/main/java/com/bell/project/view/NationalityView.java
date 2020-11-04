package com.bell.project.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description = "Гражданство")
public class NationalityView {

    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public String id;

    @Size(max = 20)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Название", example = "Office")
    public String name;

    @Size(max = 3)
    @NotEmpty(message = "Code cannot be null")
    @ApiModelProperty(value = "Код", example = "01")
    public String code;

    @Override
    public String toString() {
        return "Nationality: " +
                "name = " + name +
                "; code = " + code;
    }
}
