package com.zup.orange.modules.vaccine.model;

import com.zup.orange.modules.validation.Groups;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
@Table
public class Vaccines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(groups = Groups.UserRegister.class)
    @Column
    private String name;
    
    @NotNull(groups = Groups.UserRegister.class)
    @JoinColumn
    private Long user_id;

    @Column
    private LocalDate application_date;


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

    public LocalDate getApplication_date() {
        return application_date;
    }

    public void setApplication_date(LocalDate application_date) {
        this.application_date = application_date;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Vaccines(String name, Long user_id, LocalDate application_date) {
        this.name = name;
        this.user_id = user_id;
        this.application_date = application_date;
    }

    public Vaccines() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vaccines vaccines = (Vaccines) o;

        return id.equals(vaccines.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Vaccines{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user_id=" + user_id +
                ", application_date=" + application_date +
                '}';
    }
}
