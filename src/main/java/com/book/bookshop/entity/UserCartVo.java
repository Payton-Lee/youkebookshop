package com.book.bookshop.entity;

import lombok.Data;
/*
* 用户购物测信息
*
* */

@Data
public class UserCartVo {
    private Integer num;
    private double totalPrice;

    public double getTotalPrice() {
        return totalPrice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
