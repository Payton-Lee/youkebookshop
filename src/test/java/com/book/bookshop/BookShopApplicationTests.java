package com.book.bookshop;

import com.book.bookshop.entity.OrderQueryVo;
import com.book.bookshop.mapper.CartMapper;
import com.book.bookshop.mapper.OrderMapper;
import com.book.bookshop.service.BookService;
import com.book.bookshop.utils.OrderUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookShopApplicationTests {
    @Autowired
    private BookService bookService;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Test
    void contextLoads() {
        bookService.list().forEach(System.out::println);
    }
    @Test
    public void findCartList(){
        cartMapper.findCartListByUserId(1).forEach(System.out::println);
    }
    @Test
    public void findOrderList(){
        orderMapper.findOrderAndOrderDetailListByUser(1);
    }
    @Test
    public void testCreateOrderNo() {
        System.out.println(OrderUtils.createOrderNum());

    }

}
