package com.bell.project.view.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description = "Фильтр Работника")
public class UserFilter {

    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Long officeId;

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

    @Size(max = 2)
    @ApiModelProperty(value = "Код документа", example = "01")
    public String documentCode;

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