package com.book.bookshop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@Data
@TableName(value = "bs_cart")
public class Cart extends Model<Cart> {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Integer count;

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    // 屏蔽book属性和数据库表中字段映射
    @TableField(exist = false)
    private Book book;
}
