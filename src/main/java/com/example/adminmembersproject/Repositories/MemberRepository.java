package com.example.adminmembersproject.Repositories;

import com.example.adminmembersproject.Entities.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface MemberRepository extends JpaRepository<Members, Integer> {

}
