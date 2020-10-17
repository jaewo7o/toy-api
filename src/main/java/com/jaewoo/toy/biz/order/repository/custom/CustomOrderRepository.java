package com.jaewoo.toy.biz.order.repository.custom;

import com.jaewoo.toy.biz.order.domain.Order;
import com.jaewoo.toy.biz.order.domain.spec.OrderSearch;

import java.util.List;

public interface CustomOrderRepository {
    public List<Order> search(OrderSearch orderSearch);
}
