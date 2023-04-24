package com.ukjpa.practice.repository;

import com.ukjpa.practice.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
