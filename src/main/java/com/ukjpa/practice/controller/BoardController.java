package com.ukjpa.practice.controller;

import com.ukjpa.practice.entity.BoardEntity;
import com.ukjpa.practice.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board/write")
    public String boardWriteForm() {
        return "boardwrite";
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(BoardEntity boardEntity) {

        boardService.write(boardEntity);

        return "redirect:/board/write";
    }

    @GetMapping("/board/list")
    public String boardList() {
        return "boardlist";
    }
}
