package com.k15t.pat.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 30, message = "Name should be above 2 and less that 30 characters")
    private String Name;
    @NotBlank(message = "Password is mandatory")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
            message = "Password, minimum 8 characters, at least one letter and one number")
    private String Password;
    @NotBlank(message = "Address is mandatory")
    private String Address;
    @NotBlank(message = "Email is mandatory")
    @javax.validation.constraints.Email(message = "Email format is wrong please")
    @Pattern(regexp = ".+@.+\\..+", message = "Please provide a valid email address")
    private String Email;
    private String Number;

    public User() {
    }

    public User(String Name, String Password, String Address, String Email, String Number) {
        this.Name = Name;
        this.Password = Password;
        this.Address = Address;
        this.Email = Email;
        this.Number = Number;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }
}
