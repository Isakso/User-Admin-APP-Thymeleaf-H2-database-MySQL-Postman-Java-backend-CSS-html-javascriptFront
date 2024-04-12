package com.example.adminmembersproject.Services;

import com.example.adminmembersproject.Entities.Admin;
import com.example.adminmembersproject.Entities.Members;
import com.example.adminmembersproject.Exceptions.ResourceNotFoundException;
import com.example.adminmembersproject.Repositories.AdminRepository;
import com.example.adminmembersproject.Repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService implements MemberServiceInterface {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<Members> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Members getMemberById() {
        return null;
    }

    @Override
    public Members getMemberById(int id) {
        if (memberRepository.existsById(id)) {
            Optional<Members> existingMember = memberRepository.findById(id);
            if (existingMember.isPresent()) {
                return existingMember.get();
            }

        }
        throw new ResourceNotFoundException("Members", "id", id);
    }

    @Override
    public Members addNewMember(Members member) {

        Admin admin = member.getAdmin();
        if (admin != null) {
            if (member.getId() == 0) {
                memberRepository.save(member);
            } else {
                Optional<Admin> existingAdmin = adminRepository.findById(admin.getId());
                if (!existingAdmin.isPresent()) {
                    throw new ResourceNotFoundException("Admin", "id", admin.getId());
                }
            }
        }
        return memberRepository.save(member);
    }

    @Override
    public void deleteMemberById(int id) throws ResourceNotFoundException {

        memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Member", "id", id));
        memberRepository.deleteById(id);

    }

    @Override
    public Members updateMember(int id, Members updatedMember) {
        Members existingMember = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member", "id", id));
        Members members = new Members(updatedMember.getFirstName(),
                updatedMember.getLastName(), updatedMember.getEmail(), updatedMember.getPhoneNo(), updatedMember.getDateOfBirth(), updatedMember.getAddress());
                 existingMember = updatedMember;
        // Save the updated member back to the database*/
        return memberRepository.save(updatedMember);
    }


}
