package com.ukjpa.practice.controller;

import com.ukjpa.practice.DTO.MemberDTO;
import com.ukjpa.practice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;
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
        return "/member/join";
    }

    @PostMapping("/member/join")
    public String memberJoinPro(@ModelAttribute MemberDTO memberDTO) {
        System.out.println("memberDTO = " + memberDTO);
        System.out.println("MEMBERPASSWORD" + memberDTO.getMemberPassword());
        memberService.join(memberDTO);

        return "/member/login";
    }

    @GetMapping("/member/")
    public String memberList(Model model) {
        List<MemberDTO> memberList = memberService.findAll();
        model.addAttribute("member", memberList);

        System.out.println("model = " + model);
        System.out.println("memberList = " + memberList);

        return "/member/list";
    }

    @GetMapping("/member/login")
    public String memberLoginForm() {
        return "/member/login";
    }

    @PostMapping("/member/login")
    public String memberLogin(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        MemberDTO loginResult = memberService.login(memberDTO);

        if (loginResult != null) {
            session.setAttribute("loginEmail", loginResult.getMemberEmail());
            return "/member/myinfo";
        } else {
            return "/member/login";
        }
    }

    @GetMapping("/member/{id}")
    public String memberDetail(@PathVariable Long id, Model model) {

        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member", memberDTO);
        return "/member/detail";
    }

    @GetMapping("/member/delete/{id}")
    public String memberDelete(@PathVariable Long id) {
        memberService.deleteById(id);
        return "redirect:/member/";
    }

    @GetMapping("/member/update")
    public String updateForm(HttpSession session, Model model) {
        String getMyEmail = (String) session.getAttribute("loginEmail");
        MemberDTO memberDTO = memberService.updateForm(getMyEmail);
        model.addAttribute("updateMember", memberDTO);
        return "/member/update";
    }

    @PostMapping("/member/update")
    public String update(@ModelAttribute MemberDTO memberDTO) {
        memberService.update(memberDTO);
        return "redirect:/member/" + memberDTO.getId();
    }

    @GetMapping("/member/myinfo")
    public String myinfo() {
        return "/member/myinfo";
    }

    @GetMapping("/member/logout")
    public String logout(HttpSession session) {
        memberService.logout(session);
        return "index";
    }
}
