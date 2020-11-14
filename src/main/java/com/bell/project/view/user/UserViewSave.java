package com.bell.project.view.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "Фильтр работника для сохранения")
public class UserViewSave {

    @NotEmpty
    @ApiModelProperty(value = "ID офиса")
    public Long officeId;

    @Size(max = 15)
    @NotEmpty
    @ApiModelProperty(value = "Имя", example = "Иван")
    public String firstName;

    @Size(max = 15)
    @ApiModelProperty(value = "Фамилия", example = "Иванов")
    public String secondName;

    @Size(max = 15)
    @ApiModelProperty(value = "Отчество", example = "Иванович")
    public String middleName;

    @Size(max = 20)
    @NotEmpty
    @ApiModelProperty(value = "Должность", example = "Уборщик")
    public String position;

    @Size(max = 11)
    @ApiModelProperty(value = "Номер", example = "88001112233")
    public String phone;

    @Size(max = 2)
    @ApiModelProperty(value = "Код документа", example = "01")
    public String docCode;

    @Size(max = 120)
    @ApiModelProperty(value = "Наименование документа", example = "Удостоверение беженца")
    public String docName;

    @Size(max = 10)
    @ApiModelProperty(value = "Номер документа", example = "954762")
    public String docNumber;

    @ApiModelProperty(value = "Дата документа", example = "2015-12-17")
    public Date docDate;

    @Size(max = 3)
    @ApiModelProperty(value = "Номер Страны", example = "003")
    public String citizenshipCode;

    @ApiModelProperty(value = "Идентифицирован", example = "TRUE")
    public Boolean isIdentified;

    @Override
    public String toString() {
        return "UserViewSave{" +
                "officeId=" + officeId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", documentName='" + docName + '\'' +
                ", documentNumber='" + docNumber + '\'' +
                ", documentDate=" + docDate +
                ", citizenshipCode='" + citizenshipCode + '\'' +
                ", isIdentified=" + isIdentified +
                '}';
    }
}