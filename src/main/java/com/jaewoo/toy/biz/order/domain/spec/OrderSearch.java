package com.jaewoo.toy.biz.order.domain.spec;

import com.jaewoo.toy.biz.order.domain.Order;
import com.jaewoo.toy.biz.order.domain.constant.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import static com.jaewoo.toy.biz.order.domain.spec.OrderSpec.memberNameLike;
import static com.jaewoo.toy.biz.order.domain.spec.OrderSpec.orderStatusEq;
import static org.springframework.data.jpa.domain.Specification.where;

@Getter
@Setter
public class OrderSearch {
    private String memberName;      //회원 이름
    private OrderStatus orderStatus;//주문 상태

    public Specification<Order> toSpecification() {
        return where(memberNameLike(memberName))
                .and(orderStatusEq(orderStatus));
    }
}
