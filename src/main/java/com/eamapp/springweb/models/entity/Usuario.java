package com.eamapp.springweb.models.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.util.Date;
import jakarta.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

public class Usuario {
    private String id;
    @NotEmpty
    @Size(min = 3, max = 8)
    private String username;

    @NotEmpty(message = "la contraseña no puede ser vacias")
    private String password;

    @NotEmpty
    @Email
    private String email;

    @NotNull
    @Past
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date fechaNacimiento;

    @Valid
    private Pais pais;

    // @NotEmpty
    // private String pais;

    // public String getPais() {
    //     return pais;
    // }

    // public void setPais(String pais) {
    //     this.pais = pais;
    // }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
