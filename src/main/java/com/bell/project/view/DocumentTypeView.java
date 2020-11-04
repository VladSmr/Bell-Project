package com.bell.project.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description = "Тип документа")
public class DocumentTypeView {

    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public String id;

    @Size(max = 10)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Имя", example = "Passport")
    public String name;

    @Size(max = 2)
    @NotEmpty(message = "code cannot be null")
    @ApiModelProperty(value = "Код", example = "01")
    public String code;

    @Override
    public String toString() {
        return "DocumentType: " +
                "name = " + name +
                "; code = " + code;
    }
}
