package com.zup.orange.modules.user.model;

import com.zup.orange.modules.validation.Groups;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames ={"name", "email", "cpf", "data_nasc"})})
public class Users {

    @NotNull(groups = Groups.UserRegister.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Nome não pode estar vazio.")
    @Size(min = 5, max = 50, message = "Nome precisa ter entre 5 e 50 caracteres")
    @Column
    private String name;

    @NotEmpty(message = "Email não pode estar vazio.")
    @Email(message = "Email should be valid")
    @Column
    private String email;

    @NotEmpty(message = "Cpf não pode estar vazio.")
    @Size(min = 11, max = 11, message = "CPF precisa ter 11 digitos")
    @Column
    private String cpf;

    @Column
    private LocalDate data_nasc;

    public Users(String name, String email, String cpf, LocalDate data_nasc) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.data_nasc = data_nasc;
    }

    public Users() {

    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(LocalDate data_nasc) {
        this.data_nasc = data_nasc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        return id.equals(users.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", data_nasc=" + data_nasc +
                '}';
    }
}
