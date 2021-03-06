package com.bell.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;

import java.util.Set;

/**
 * Сущность граждансвто
 */
@Entity
public class Nationality {

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
     * Название страны
     */
    @Column(name = "name", length = 20, nullable = false)
    private String name;

    /**
     * Код страны
     */
    @Column(name = "code", length = 3, nullable = false)
    private String code;

    /**
     * Связь с юзерами
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "nationality")
    private Set<User> users;

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}