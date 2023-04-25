package com.ukjpa.practice.service;

import com.ukjpa.practice.entity.BoardEntity;
import com.ukjpa.practice.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    private BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void write(BoardEntity boardEntity) {
        boardRepository.save(boardEntity);
    }
}
