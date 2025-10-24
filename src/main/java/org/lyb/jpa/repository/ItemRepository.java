package org.lyb.jpa.repository;

import org.lyb.jpa.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
