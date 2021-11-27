package com.book.bookshop.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.book.bookshop.entity.Book;
import org.springframework.stereotype.Repository;

/*
* 图书接口
* */
@Repository
public interface BookMapper extends BaseMapper<Book> {

}
