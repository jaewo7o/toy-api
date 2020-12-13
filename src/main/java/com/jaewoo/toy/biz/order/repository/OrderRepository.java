package com.jaewoo.toy.biz.order.repository;

import com.jaewoo.toy.biz.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
