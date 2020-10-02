package com.jaewoo.toy.biz.item.repository;

import com.jaewoo.toy.biz.item.domain.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
