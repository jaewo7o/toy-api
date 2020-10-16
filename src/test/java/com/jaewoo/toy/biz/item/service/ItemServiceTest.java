package com.jaewoo.toy.biz.item.service;

import com.jaewoo.toy.biz.item.domain.entity.Book;
import com.jaewoo.toy.biz.item.domain.entity.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Test
    void saveItem() {
        // given
        Book book = new Book();
        book.setName("해변의 카프카");
        book.setPrice(23000);
        book.setStockQuantity(10);
        book.setIsbn("123-1");
        book.setAuthor("하루키");

        // when
        Item saveBook = itemService.saveItem(book);

        // then
        Assertions.assertThat(saveBook).isNotNull();
        Assertions.assertThat(saveBook.getId()).isNotNull();
        Assertions.assertThat(saveBook.getName()).isEqualTo(book.getName());
    }

    @Test
    void findItems() {
        // given

        // when
        List<Item> items = itemService.findItems();

        // then
        Assertions.assertThat(items).isNotEmpty();
    }

    @Test
    void findById() {
    }
}