package com.example.adminmembersproject.Controllers;

import com.example.adminmembersproject.Entities.Admin;
import com.example.adminmembersproject.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    @GetMapping ("/allAdmins")
    public List<Admin> getAllAdmins(){
        return adminService.getAllAdmins();
    }


}
