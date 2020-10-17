package com.jaewoo.toy.biz.order.service;

import com.jaewoo.toy.biz.item.domain.entity.Book;
import com.jaewoo.toy.biz.item.domain.entity.Item;
import com.jaewoo.toy.biz.item.repository.ItemRepository;
import com.jaewoo.toy.biz.member.domain.Member;
import com.jaewoo.toy.biz.member.repository.MemberRepository;
import com.jaewoo.toy.biz.order.domain.Address;
import com.jaewoo.toy.biz.order.domain.Order;
import com.jaewoo.toy.biz.order.domain.constant.OrderStatus;
import com.jaewoo.toy.biz.order.repository.OrderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ItemRepository itemRepository;

    @Test
    void order() {
        // given
        Member member = createMember();
        Item item = createBook("시골 JPA", 10000, 10);
        int orderCount = 2;

        // when
        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);

        // then
        Order order = orderRepository.findById(orderId).get();

        Assertions.assertThat(order.getStatus()).isEqualTo(OrderStatus.ORDER);
    }

    @Test
    void cancelOrder() {
    }

    @Test
    void findOrders() {
    }

    private Member createMember() {
        Member member = new Member();
        member.setName("회원1");
        member.setAddress(new Address("서울", "강가", "123-123"));
        memberRepository.save(member);
        return member;
    }

    private Book createBook(String name, int price, int stockQuantity) {
        Book book = new Book();
        book.setName(name);
        book.setStockQuantity(stockQuantity);
        book.setPrice(price);
        itemRepository.save(book);
        return book;
    }
}