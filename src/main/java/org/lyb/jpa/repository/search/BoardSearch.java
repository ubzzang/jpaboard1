package org.lyb.jpa.repository.search;

import org.lyb.jpa.domain.Board;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardSearch {
    Page<Board> search1(Pageable pageable);
    Page<Board> searchAll(String[] types, String keyword, Pageable pageable);
}
