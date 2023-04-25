package com.ukjpa.practice.controller;

import com.ukjpa.practice.DTO.MemberDTO;
import com.ukjpa.practice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member/join")
    public String memberJoin() {
        return "memberjoin";
    }

    @PostMapping("/member/join")
    public String memberJoinPro(@ModelAttribute MemberDTO memberDTO) {
        System.out.println("memberDTO = " + memberDTO);
        System.out.println("MEMBERPASSWORD" + memberDTO.getMemberPassword());
        memberService.join(memberDTO);

        return "index";
    }

    @GetMapping("/member/")
    public String memberList(Model model) {
        List<MemberDTO> memberList = memberService.findAll();
        model.addAttribute("member", memberList);

        System.out.println("model = " + model);
        System.out.println("memberList = " + memberList);

        return "memberlist";
    }

    @GetMapping("/member/login")
    public String memberLogin() {
        return "login";
    }
}
