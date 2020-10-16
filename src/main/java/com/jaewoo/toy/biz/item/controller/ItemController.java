package com.jaewoo.toy.biz.item.controller;

import com.jaewoo.toy.biz.item.domain.entity.Item;
import com.jaewoo.toy.biz.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping("/items")
    public List<Item> getItems() {
        return itemService.findItems();
    }
}
