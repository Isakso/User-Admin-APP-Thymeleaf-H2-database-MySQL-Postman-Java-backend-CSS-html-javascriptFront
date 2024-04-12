package com.example.adminmembersproject.Services;

import com.example.adminmembersproject.Entities.Admin;
import com.example.adminmembersproject.Repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements AdminServiceInterface{
    @Autowired
    private AdminRepository adminRepository;
    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }
}
