package com.example.adminmembersproject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;

import javax.persistence.*;
import java.util.List;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @JsonIgnoreProperties("admin")
    @OneToMany(mappedBy = "admin", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Members> membersList;

    public Admin() {

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
    //returns all members from the list a list
    public List<Members>getMembersList(){
        return membersList;
    }
    public void setMembers(List<Members>membersList){
        this.membersList = membersList;
    }
}
