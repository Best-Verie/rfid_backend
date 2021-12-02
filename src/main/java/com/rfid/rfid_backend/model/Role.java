package com.rfid.rfid_backend.model;


import com.rfid.rfid_backend.enumerations.ERoleName;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 60)
    private ERoleName name;

    @NotNull
    @Size(min = 3, max = 40)
    private String description;

    public Role() {

    }

    public Role(ERoleName name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERoleName getName() {
        return name;
    }

    public void setName(ERoleName name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
