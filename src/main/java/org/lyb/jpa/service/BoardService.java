package org.lyb.jpa.service;

import org.lyb.jpa.domain.Board;
import org.lyb.jpa.dto.BoardDTO;
import org.lyb.jpa.dto.PageRequestDTO;
import org.lyb.jpa.dto.PageResponseDTO;

import java.util.List;

public interface BoardService {
    Long insertBoard(BoardDTO board);
    List<BoardDTO> findAllBoard();
    BoardDTO findBoardById(Long bno, Integer mode);
    void updateBoard(BoardDTO boardDTO);
    void deleteBoard(Long bno);
    PageResponseDTO<BoardDTO> getList(PageRequestDTO pageRequestDTO);

    default Board dtoToEntity(BoardDTO boardDTO) {
        Board board = Board.builder()
                .bno(boardDTO.getBno())
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .author(boardDTO.getAuthor())
                .build();
        return board;
    }
    default BoardDTO entityToDTO(Board board) {
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .content(board.getContent())
                .author(board.getAuthor())
                .readcount(board.getReadcount())
                .regDate(board.getRegDate())
                .updateDate(board.getUpdateDate())
                .build();
        return boardDTO;
    }
}
