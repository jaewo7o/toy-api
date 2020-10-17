package com.jaewoo.toy.biz.order.repository;

import com.jaewoo.toy.biz.order.domain.Order;
import com.jaewoo.toy.biz.order.repository.custom.CustomOrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

//public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order>, CustomOrderRepository {
public interface OrderRepository extends JpaRepository<Order, Long> {

}
