package com.jaewoo.toy.biz.item.repository;

import com.jaewoo.toy.biz.item.domain.entity.Book;
import com.jaewoo.toy.biz.item.domain.entity.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ItemRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void saveBookItem() {
        Book book = new Book();
        book.setName("JPA 프로그래밍 Basic");
        book.setPrice(20000);
        book.setStockQuantity(12);
        book.setIsbn("2020-1");
        book.setAuthor("Test Author");

        Book saveBook = testEntityManager.persist(book);

        Item item = itemRepository.findById(saveBook.getId()).orElseThrow(() -> new NoSuchElementException());

        Assertions.assertThat(item.getName()).isEqualTo(book.getName());
    }

}