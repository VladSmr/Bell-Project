package com.bell.project.view.office;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Представление сущности офиса
 */
@ApiModel(description = "Офис (короткая версия)")
public class OfficeViewShort {

    /**
     * ID офиса
     */
    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Long id;

    /**
     * Название офиса
     */
    @Size(max = 15)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Название", example = "Office")
    public String name;

    /**
     * Активность офиса
     */
    @NotNull(message = "Active cannot be null")
    @ApiModelProperty(value = "Работает", example = "TRUE")
    public Boolean isActive;

    @Override
    public String toString() {
        return "OfficeViewShort{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}