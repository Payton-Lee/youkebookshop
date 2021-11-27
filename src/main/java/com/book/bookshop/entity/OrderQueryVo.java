package com.book.bookshop.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*
* 订单查询条件包装类
* */
public class OrderQueryVo {
    private Integer page;
    private Integer pageSize;
    private String orderNum;
    private String tradeStatus;
    private String orderBy;
    private Integer userId;

    //分页起始位置
    private Integer begin;
    //分页结束位置
    private Integer end;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Integer getBegin() {
        return begin;
    }

    public Integer getEnd() {
        return end;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }
}
