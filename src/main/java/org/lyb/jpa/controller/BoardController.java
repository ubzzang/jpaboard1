package org.lyb.jpa.controller;

import lombok.extern.log4j.Log4j2;
import org.lyb.jpa.domain.Board;
import org.lyb.jpa.dto.BoardDTO;
import org.lyb.jpa.dto.PageRequestDTO;
import org.lyb.jpa.dto.PageResponseDTO;
import org.lyb.jpa.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j2
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("register")
    public void registerGet() {
        log.info("registerGet");
    }

    @PostMapping("register")
    public String registerPost(BoardDTO boardDTO) {
        log.info("registerPost");
        Long bno = boardService.insertBoard(boardDTO);
        log.info("board insert success:bno=" + bno);
        return "redirect:/board/list";
    }

    @GetMapping("list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        PageResponseDTO<BoardDTO> responseDTO = boardService.getList(pageRequestDTO);
        model.addAttribute("responseDTO", responseDTO);
        model.addAttribute("pageRequestDTO", pageRequestDTO);
        // 로그 찍기
        log.info("dtoList: {}", responseDTO.getDtoList());
        responseDTO.getDtoList().forEach(dto -> log.info("dto: {}", dto));
    }

    //@GetMapping("list")
    public void list(Model model) {
        log.info("list");
        model.addAttribute("boards", boardService.findAllBoard());
    }

    @GetMapping({"read", "modify"})
    public void read(Long bno, Integer mode, PageRequestDTO pageRequestDTO, Model model) {
        log.info("read: " + bno);
        // 생략가능 소문자로 이름 똑같이 적으면 ..
        model.addAttribute("pageRequestDTO", pageRequestDTO);
        model.addAttribute("board", boardService.findBoardById(bno, mode));
    }

    @PostMapping("modify")
    public String modifyBoard(BoardDTO boardDTO, RedirectAttributes redirectAttributes) {
        log.info("modifyBoard" + boardDTO);
        boardService.updateBoard(boardDTO);
        redirectAttributes.addAttribute("bno", boardDTO.getBno());
        redirectAttributes.addAttribute("mode", 1);
        return "redirect:/board/read";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("bno") Long bno) {
        boardService.deleteBoard(bno);
        return "redirect:/board/list";
    }

}
