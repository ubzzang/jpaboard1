package org.lyb.jpa.repository;

import org.junit.jupiter.api.Test;
import org.lyb.jpa.domain.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class BoardRepositoryTest {
    private static final Logger log = LoggerFactory.getLogger(BoardRepositoryTest.class);
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void SearchBoard(){
        Pageable pageable = PageRequest.of(0, 5, Sort.by("bno").descending());
        Page<Board> result=boardRepository.search1(pageable);
        List<Board> boards=result.getContent();
        for(Board board:boards){
            log.info(board.toString());
        }
        log.info("count: {}", result.stream().count());
        log.info("size: {}", result.getSize());
    }
    @Test
    public void insertBoard() {
        Board board = Board.builder()
                .title("title1")
                .content("content1")
                .author("user00")
                .build();
        boardRepository.save(board);
    }
    @Test
    public void findLikeAll() {
//        List<Board> boards = boardRepository.findByTitleAndContent("2");
//        for (Board board : boards) {
//            log.info(board.toString());
//        }
    }
}
