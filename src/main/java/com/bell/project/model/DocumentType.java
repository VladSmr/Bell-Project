package com.bell.project.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Document_Type")
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Version
    private Integer version;

    @Column(name = "name", length = 120, nullable = false)
    private String name;

    @Column(name = "code", length = 2, nullable = false)
    private String code;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "documentType")
    private Set<Document> documents;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }
}