package com.careflow.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity

public class Patient {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false) private String name;
    @Column(nullable=false, unique=true) private String email;
    @Column(nullable=false) private String password;
    private String phone;
    private LocalDate dateOfBirth;
    private String gender;
    private String address;
    private String bloodGroup;

    public Patient() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }

    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getBloodGroup() { return bloodGroup; }

    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }
}
