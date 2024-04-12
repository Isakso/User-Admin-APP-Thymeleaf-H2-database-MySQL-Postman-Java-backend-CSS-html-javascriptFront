package com.example.adminmembersproject.Services;

import com.example.adminmembersproject.Entities.Members;

import java.util.List;

public interface MemberServiceInterface {
    List<Members> getAllMembers();
    Members getMemberById();

    Members getMemberById(int id);

    Members addNewMember(Members member);
    void deleteMemberById(int id);
    Members updateMember(int id, Members member);


}
