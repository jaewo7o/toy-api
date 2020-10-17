package com.jaewoo.toy.biz.order.service;

import com.jaewoo.toy.biz.item.domain.entity.Item;
import com.jaewoo.toy.biz.item.service.ItemService;
import com.jaewoo.toy.biz.member.domain.Member;
import com.jaewoo.toy.biz.member.repository.MemberRepository;
import com.jaewoo.toy.biz.order.domain.Delivery;
import com.jaewoo.toy.biz.order.domain.Order;
import com.jaewoo.toy.biz.order.domain.OrderItem;
import com.jaewoo.toy.biz.order.domain.spec.OrderSearch;
import com.jaewoo.toy.biz.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class OrderService {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ItemService itemService;

    /**
     * 주문
     */
    public Long order(Long memberId, Long itemId, int count) {

        //엔티티 조회
        Member member = memberRepository.findById(memberId).orElseThrow(NoSuchElementException::new);
        Item item = itemService.findById(itemId);

        //배송정보 생성
        Delivery delivery = new Delivery(member.getAddress());
        //주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
        //주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);

        //주문 저장
        orderRepository.save(order);
        return order.getId();
    }


    /**
     * 주문 취소
     */
    public void cancelOrder(Long orderId) {

        //주문 엔티티 조회
        Order order = orderRepository.findById(orderId).orElseThrow(NoSuchElementException::new);

        //주문 취소
        order.cancel();
    }

    /**
     * 주문 검색
     */
//    public List<Order> findOrders(OrderSearch orderSearch) {
//        return orderRepository.findAll(orderSearch.toSpecification()); // Specification 사용
//        //return orderRepository.search(orderSearch);  //QueryDSL 사용
//    }

}
