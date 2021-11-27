package com.book.bookshop.service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.bookshop.entity.Book;
import com.book.bookshop.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


/*
* 图书业务层
* */
@Service
public class BookService extends ServiceImpl<BookMapper, Book> {
    @Autowired
    private BookMapper bookMapper;


    public String checkSearch(String search, HttpSession session){
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", search);
        Book book = bookMapper.selectOne(queryWrapper);
        if(book == null){
            return "101"; // 图书不存在，不可以跳转
        }else{
            session.setAttribute("search", search);
            return "102"; // 图书存在，可以跳转
        }
    }
}
