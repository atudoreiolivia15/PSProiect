package com.spring.model;

import jakarta.persistence.*;
@Entity
public class Tag {
    @Id
    private int id;
    @Column(name="tag_name")
    private String name;

    public Tag(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
