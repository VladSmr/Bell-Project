package com.bell.project.view.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

/**
 * Представление юзеров
 */
@ApiModel(description = "Работники офиса")
public class UserViewList {

    /**
     * ID
     */
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Long id;

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

    @Override
    public String toString() {
        return "UserViewList{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}