package com.jaewoo.toy.biz.order.domain;

import com.jaewoo.toy.biz.order.domain.constant.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    public Delivery() {
    }

    public Delivery(Address address) {
        this.address = address;
        this.status = DeliveryStatus.READY;
    }
}
