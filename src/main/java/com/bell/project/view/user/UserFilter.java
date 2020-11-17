package com.bell.project.view.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Фильтр юзера для поиска по ID офиса
 */
@ApiModel(description = "Фильтр Работника")
public class UserFilter {

    /**
     * ID офиса
     */
    @NotNull
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Long officeId;

    /**
     * Имя юзера
     */
    @Size(max = 15)
    @ApiModelProperty(value = "Имя", example = "Иван")
    public String firstName;

    /**
     * Фамилия юзера
     */
    @Size(max = 15)
    @ApiModelProperty(value = "Фамилия", example = "Иванов")
    public String secondName;

    /**
     * Отчество юзера
     */
    @Size(max = 15)
    @ApiModelProperty(value = "Отчество", example = "Иванович")
    public String middleName;

    /**
     * Должность юзера
     */
    @Size(max = 20)
    @ApiModelProperty(value = "Должность", example = "Уборщик")
    public String position;

    /**
     * Код типа документа юзера
     */
    @Size(max = 2)
    @ApiModelProperty(value = "Код документа", example = "01")
    public String documentCode;

    /**
     * Код страны юзера
     */
    @Size(max = 3)
    @ApiModelProperty(value = "Номер Страны", example = "003")
    public String citizenshipCode;

    @Override
    public String toString() {
        return "UserFilter{" +
                "officeId=" + officeId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", position='" + position + '\'' +
                ", documentCode='" + documentCode + '\'' +
                ", citizenshipCode='" + citizenshipCode + '\'' +
                '}';
    }
}