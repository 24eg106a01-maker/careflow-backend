package com.careflow.entity;

import jakarta.persistence.*;

@Entity

public class Doctor {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false) private String name;
    @Column(nullable=false, unique=true) private String email;
    private String phone;
    private String specialization;
    private String qualification;
    private Integer experience;
    @ManyToOne private Department department;

    public Doctor() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getSpecialization() { return specialization; }

    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getQualification() { return qualification; }

    public void setQualification(String qualification) { this.qualification = qualification; }

    public Integer getExperience() { return experience; }

    public void setExperience(Integer experience) { this.experience = experience; }

    public Department getDepartment() { return department; }

    public void setDepartment(Department department) { this.department = department; }
}
