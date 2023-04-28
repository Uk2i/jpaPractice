package com.ukjpa.practice.service;

import com.ukjpa.practice.DTO.BoardDTO;
import com.ukjpa.practice.entity.BoardEntity;
import com.ukjpa.practice.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    private BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void write(BoardDTO boardDTO) {
        boardRepository.save(BoardEntity.toSaveEntity(boardDTO));
    }

    public List<BoardDTO> findAll() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        for (BoardEntity boardEntity : boardEntityList) {
            boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
        }
        return boardDTOList;
    }

    public BoardDTO findById(Long id) {
        Optional<BoardEntity> boardRepositoryById = boardRepository.findById(id);
        if (boardRepositoryById.isPresent()) {
            return BoardDTO.toBoardDTO(boardRepositoryById.get());
        } else {
            return null;
        }
    }

    public BoardDTO update(BoardDTO boardDTO) {
        boardRepository.save(BoardEntity.toUpdateEntity(boardDTO));
        return findById(boardDTO.getId());
    }
}
