package com.bell.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import javax.persistence.MapsId;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * Сущность Документ
 */
@Entity
public class Document {

    /**
     * ID
     */
    @Id
    @Column(name = "user_id")
    private Long id;

    /**
     * Version
     */
    @Version
    private Integer version;

    /**
     * Номер документа
     */
    @Column(name = "number", length = 10, nullable = false)
    private String number;

    /**
     * Дата документа
     */
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    /**
     * Связь с типом документа
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "document_type_id", nullable = false)
    private DocumentType documentType;

    /**
     * Связь с юзером
     */
    @OneToOne(mappedBy = "document")
    @MapsId
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}