package com.book.bookshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.book.bookshop.entity.Order;
import com.book.bookshop.entity.OrderQueryVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper extends BaseMapper<Order> {
    /*
    *根据用户id查询用户订单以及订单明细
    * */
    List<Order> findOrderAndOrderDetailListByUser(Integer id);

    /**
     * 查询记录总数
     */
//    Integer findOrderCountByUser(OrderQueryVo orderQueryVo);
}
