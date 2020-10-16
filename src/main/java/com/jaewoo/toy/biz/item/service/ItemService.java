package com.jaewoo.toy.biz.item.service;

import com.jaewoo.toy.biz.item.domain.entity.Item;
import com.jaewoo.toy.biz.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findById(Long itemId) {
        return itemRepository.findById(itemId).orElseThrow(NoSuchElementException::new);
    }
}
