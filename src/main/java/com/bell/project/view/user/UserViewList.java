package com.bell.project.view.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

@ApiModel(description = "Работники офиса")
public class UserViewList {

    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Long id;

    @Size(max = 15)
    @ApiModelProperty(value = "Имя", example = "Иван")
    public String firstName;

    @Size(max = 15)
    @ApiModelProperty(value = "Фамилия", example = "Иванов")
    public String secondName;

    @Size(max = 15)
    @ApiModelProperty(value = "Отчество", example = "Иванович")
    public String middleName;

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
