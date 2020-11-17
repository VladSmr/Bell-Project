package com.bell.project.view.documenttype;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

/**
 * Представление сущности Типа Документа
 */
@ApiModel(description = "Тип документа")
public class DocumentTypeView {

    /**
     * Название типа документа
     */
    @Size(max = 10)
    @ApiModelProperty(value = "Имя", example = "Passport")
    public String name;

    /**
     * Код типа документа
     */
    @Size(max = 2)
    @ApiModelProperty(value = "Код", example = "01")
    public String code;

    @Override
    public String toString() {
        return "DocumentType: " +
                "name = " + name +
                "; code = " + code;
    }
}
