package com.ukjpa.practice.controller;

import com.ukjpa.practice.DTO.BoardDTO;
import com.ukjpa.practice.entity.BoardEntity;
import com.ukjpa.practice.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/write")
    public String boardWriteForm() {
        return "/board/write";
    }

    @PostMapping("/write")
    public String boardWritePro(@ModelAttribute BoardDTO boardDTO) {
        boardService.write(boardDTO);
        return "index";
    }

    @GetMapping("/list")
    public String boardList(Model model) {
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "/board/list";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "/board/detail";
    }
}
