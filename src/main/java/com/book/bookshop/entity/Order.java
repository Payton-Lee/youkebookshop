package com.book.bookshop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.util.List;

/*
* 订单实体类
* */
@Data
@TableName("bs_order")
public class Order {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String orderNum;
    private Date createDate;
    private Integer userId;
    private Integer addressId;
    private String orderStatus;

    //用户信息
    @TableField(exist = false)
    private User user;

    //地址信息
    @TableField(exist = false)
    private Address address;

    //订单明细
    @TableField(exist = false)
    private List<OrderItem> orderItems;

    // 订单总金额
    @TableField(exist = false)
    private double totalPrice;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
