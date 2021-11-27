package com.book.bookshop.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.book.bookshop.entity.enums.Category;
import com.book.bookshop.entity.enums.Suit;
import lombok.Data;

import java.util.Date;

/*
* 图书实体类
* */
@Data
@TableName(value = "bs_book")
public class Book extends Model<Book> {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String isbn;
    private String name;
    private String author;
    private String publisher;
    private Date publishDate;
    private double oldPrice;
    private double newPrice;
    private String authorLoc;
    private Suit suit;
    private Category category;
    private String info;
    private String imgUrl;

    public double getNewPrice() {
        return newPrice;
    }

    public Integer getId() {
        return id;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public Category getCategory() {
        return category;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public String getAuthor() {
        return author;
    }

    public String getAuthorLoc() {
        return authorLoc;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getInfo() {
        return info;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public String getPublisher() {
        return publisher;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAuthorLoc(String authorLoc) {
        this.authorLoc = authorLoc;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

}
