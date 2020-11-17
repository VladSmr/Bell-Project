package com.bell.project.view.user;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Представление юзера для обновления
 */
@ApiModel(description = "Фильтр работника для апдейта")
public class UserViewUpdate {

    /**
     * ID
     */
    @NotNull
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Long id;

    /**
     * ID офиса
     */
    @ApiModelProperty(value = "ID офиса")
    public Long officeId;

    /**
     * Имя юзера
     */
    @Size(max = 15)
    @NotEmpty
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
    @NotEmpty
    @ApiModelProperty(value = "Должность", example = "Уборщик")
    public String position;

    /**
     * Номер телефона юзера
     */
    @Size(max = 11)
    @ApiModelProperty(value = "Номер", example = "88001112233")
    public String phone;

    /**
     * Наименование документа юзера
     */
    @Size(max = 120)
    @ApiModelProperty(value = "Наименование документа", example = "Удостоверение беженца")
    public String docName;

    /**
     * Номер документа юзера
     */
    @Size(max = 10)
    @ApiModelProperty(value = "Номер документа", example = "954762")
    public String docNumber;

    /**
     * Дата документа юзера
     */
    @ApiModelProperty(value = "Дата документа", example = "2015-12-17")
    public Date docDate;

    /**
     * Код страны юзера
     */
    @Size(max = 3)
    @ApiModelProperty(value = "Номер Страны", example = "003")
    public String citizenshipCode;

    /**
     * Идентифицирован
     */
    @ApiModelProperty(value = "Идентифицирован", example = "TRUE")
    public Boolean isIdentified;

    @Override
    public String toString() {
        return "UserFilterUpdate{" +
                "id=" + id +
                ", officeId=" + officeId +
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