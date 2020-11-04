package com.bell.project.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "Документ")
public class DocumentView {

    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public String id;

    @Size(max = 10)
    @NotEmpty(message = "number cannot be null")
    @ApiModelProperty(value = "Номер", example = "123456")
    public String number;

    @NotEmpty(message = "Date cannot be null")
    @ApiModelProperty(value = "Дата", example = "2015-12-17")
    public Date date;

    @Override
    public String toString() {
        return "Document: " +
                "number = " + number +
                "; date = " + date;
    }
}