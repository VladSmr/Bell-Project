package com.bell.project.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "Работник")
public class UserView {

    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public String id;

    @Size(max = 15)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Имя", example = "Иван")
    public String firstName;

    @Size(max = 15)
    @NotEmpty(message = "secondName cannot be null")
    @ApiModelProperty(value = "Фамилия", example = "Иванов")
    public String secondName;

    @Size(max = 15)
    @ApiModelProperty(value = "Отчество", example = "Иванович")
    public String middleName;

    @Size(max = 20)
    @NotEmpty(message = "position cannot bu null")
    @ApiModelProperty(value = "Должность", example = "Уборщик")
    public String position;

    @Size(max = 11)
    @NotNull(message = "Phone number cannot be null")
    @ApiModelProperty(value = "Номер", example = "88001112233")
    public String phone;

    @Size(max = 120)
    @NotNull(message = "Document name cannot be null")
    @ApiModelProperty(value = "Наименование документа", example = "Удостоверение беженца")
    public String documentName;

    @Size(max = 10)
    @NotNull(message = "Document number cannot be null")
    @ApiModelProperty(value = "Номер документа", example = "954762")
    public String documentNumber;

    @NotNull(message = "Document date cannot be null")
    @ApiModelProperty(value = "Дата документа", example = "2015-12-17")
    public Date documentDate;

    @Size(max = 20)
    @NotNull(message = "Citizenship name cannot be null")
    @ApiModelProperty(value = "Гражданство", example = "USA")
    public String citizenshipName;

    @Size(max = 3)
    @NotNull(message = "Citizenship code cannot be null")
    @ApiModelProperty(value = "Номер Страны", example = "003")
    public String citizenshipCode;

    @NotNull(message = "Identification cannot be null")
    @ApiModelProperty(value = "Идентифицирован", example = "TRUE")
    public Boolean isIdentified;

    @Override
    public String toString() {
        return  "User: " +
                "id = " + id +
                "; firstName = " + firstName +
                "; secondName = " + secondName +
                "; middleName = " + middleName +
                "; position = " + position +
                "; phone = " + phone +
                "; documentName = " + documentName +
                "; documentNumber = " + documentNumber +
                "; documentDate = " + documentDate +
                "; citizenshipName = " + citizenshipName +
                "; citizenshipCode = " + citizenshipCode +
                "; isisIdentified = " + isIdentified;
    }
}
