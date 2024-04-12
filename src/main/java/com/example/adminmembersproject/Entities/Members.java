package com.example.adminmembersproject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;

@Entity
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (length = 40, nullable = false)
    private String name;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "address",nullable = false)
    private String address;
    @Column(name = "phone_no",nullable = false)
    private String phoneNo;
    @Column(name = "birth_date",nullable = false)
    private String dateOfBirth;
    @ManyToOne
    @JsonIgnoreProperties("members")
    @JoinColumn(referencedColumnName = "id")
    private Admin admin;
       public Members(String firstName, String lastName, String email, String phoneNo, String dateOfBirth, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.name = firstName + lastName;
    }

    public Members() {

    }
    public String getName() {
        this.name = firstName +""+ lastName;
        return name;
    }
    public void setName(String name) {
        //name = firstName + lastName;
        this.name=name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public Admin getAdmin() {
        return admin;
    }
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
