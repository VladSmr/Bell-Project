package com.bell.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Сущность юзер (работник)
 */
@Entity
public class User {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Version
     */
    @Version
    private Integer version;

    /**
     * Имя юзера
     */
    @Column(name = "first_name", length = 15, nullable = false)
    private String firstName;

    /**
     * Фамилия юзера
     */
    @Column(name = "second_name", length = 15, nullable = false)
    private String secondName;

    /**
     * Отчество юзера
     */
    @Column(name = "middle_name", length = 15)
    private String middleName;

    /**
     * Должность юзера
     */
    @Column(name = "position", length = 20, nullable = false)
    private String position;

    /**
     * Номер телефона юзера
     */
    @Column(name = "phone", length = 11, nullable = false)
    private String phone;

    /**
     * Идентифицирован
     */
    @Column(name = "is_identified", nullable = false)
    private Boolean isIdentified;

    /**
     * Связь юзера с офисом
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "office_id", nullable = false)
    private Office office;

    /**
     * Связь юзера с документом
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @PrimaryKeyJoinColumn
    private Document document;

    /**
     * Связь юзера с гражданством
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "nationality_id", nullable = false)
    private Nationality nationality;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIsIdentified() {
        return isIdentified;
    }

    public void setIsIdentified(Boolean identified) {
        isIdentified = identified;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }
}