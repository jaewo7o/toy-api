package com.jaewoo.toy.biz.item.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;        //이름
    private int price;          //가격
    private int stockQuantity;  //재고수량

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<Category>();

    //==Biz Method==//
    public void addStock(int orderQuantity) {
        this.stockQuantity += orderQuantity;
    }

    public void removeStock(int orderQuantity) {
        int restStock = this.stockQuantity - orderQuantity;
//        if (restStock < 0) {
//            throw new NotEnoughStockException("need more stock");
//        }
        this.stockQuantity = restStock;
    }
}