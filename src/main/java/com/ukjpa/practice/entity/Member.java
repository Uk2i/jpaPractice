package com.ukjpa.practice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "member")
public class Member{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String memberEmail;
    @Column
    private String memberName;
    @Column
    private String memberPassword;
}
