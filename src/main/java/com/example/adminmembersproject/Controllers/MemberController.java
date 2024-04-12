package com.example.adminmembersproject.Controllers;

import com.example.adminmembersproject.Entities.Members;
import com.example.adminmembersproject.Exceptions.ResourceNotFoundException;
import com.example.adminmembersproject.Repositories.MemberRepository;
import com.example.adminmembersproject.Services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller

public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;
    @PostMapping("/admin/addMember")
    public ResponseEntity<Members> addMember(@RequestParam String name,@RequestParam String address, @RequestParam String birth_date,
                                             @RequestParam String email,@RequestParam String first_name, @RequestParam String last_name, @RequestParam String phone_no)
    {
        Members member = new Members();
        member.setName(name);
        member.setAddress(address);
        member.setDateOfBirth(birth_date);
        member.setEmail(email);
        member.setFirstName(first_name);
        member.setLastName(last_name);
        member.setPhoneNo(phone_no);
        return new ResponseEntity<>(memberService.addNewMember(member), HttpStatus.CREATED);
    }
    @RequestMapping(value =  "/", method = RequestMethod.GET)
    public String getAllMembers(Model model) {
        List<Members> members = memberService.getAllMembers();
        model.addAttribute("member", members);
        return "members-list-page";
    }
    @GetMapping("/admin/getMemberbyId/{id}")
    public ResponseEntity<Members> getMemberById(@PathVariable("id") int id) {
        return ResponseEntity.ok(memberService.getMemberById(id));
    }
   // @DeleteMapping
   /*@RequestMapping(value = "/admin/deleteMember/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> deleteMemberById(@PathVariable("id") int id) {
        memberService.deleteMemberById(id);
        return new ResponseEntity<>("Member Deleted", HttpStatus.OK);
    }*/
    @RequestMapping(value = "/deleteMember/{id}", method = RequestMethod.POST)
    public String deleteMemberById(@PathVariable("id") int id, Model model) {
        memberService.deleteMemberById(id);
        model.addAttribute("member", memberService.getAllMembers());
        return "members-list-page";

    }
    /*@PutMapping("/admin/updateMemberById/{id}")
    public ResponseEntity<Members> updateCarById(@PathVariable("id") int id, @RequestBody Members member) {
        return ResponseEntity.ok(memberService.updateMember(id,member));

    }*/
    @GetMapping("/admin/updateMember/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        // Retrieve the member by ID and add it to the model
        Members member = memberService.getMemberById(id);
        model.addAttribute("member", member);
        return "update-member"; // Return the update-member.html Thymeleaf template
    }

    // Handle the POST request for updating a member
    @PostMapping("/admin/updateMember")
    public String updateMember(@RequestParam("id") int id, @RequestParam Map<String, String> formData) {
        // Retrieve the member by ID
        Members member = memberService.getMemberById(id);
        if (member != null&& memberRepository.existsById(id)) {
            // Update member properties with form data
            member.setName(formData.get("name"));
            member.setAddress(formData.get("address"));
            member.setDateOfBirth(formData.get("birth_date"));
            member.setEmail(formData.get("email"));
            member.setFirstName(formData.get("first_name"));
            member.setLastName(formData.get("last_name"));
            member.setPhoneNo(formData.get("phone_no"));
            // Save the updated member
            memberService.updateMember(id, member);
        }
        // Redirecting to the member list page after updating
        return "redirect:/";
    }

}