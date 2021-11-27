package com.book.bookshop.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.bookshop.entity.*;
import com.book.bookshop.mapper.OrderMapper;
import com.book.bookshop.utils.OrderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private CartService cartService;
    /*
    * 购买
    * */
    public String buy(List<CartVo> cartVos, Integer addId, HttpSession session){
        // 1、生成订单表
        Order order = new Order(); // 创建一个新的订单对象
        order.setAddressId(addId);  // 设置用户地址为前台传输的地址id
        User user = (User) session.getAttribute("user"); // 获取当前登录的用户信息
        order.setUserId(user.getId()); // 在order里面设置当前用户id为session中获取的用户
        order.setCreateDate(new Date()); // 新建一个日期对象，为当前提交订单的时间
        // order.setOrderNum(UUID.randomUUID().toString());
        order.setOrderNum(OrderUtils.createOrderNum()); // 调用OrderUtils.createOrderNum()方法创建一个订单号
        order.setOrderStatus("1"); // 设置当前订单状态为1（未付款）
        orderMapper.insert(order); // 将数据插入到数据库中
        // 2、生成订单明细表记录
        List<OrderItem> orderItems = new ArrayList<>(); // 创建一个orderItems为ArrayList类型
        List<Integer> cartIds = new ArrayList<>(); // 创建一个cartIds为ArrayList类型
        for (CartVo cart: cartVos){ // 遍历购物车信息类
            OrderItem orderItem = new OrderItem(); // 新建一个orderItem类
            orderItem.setBookId(cart.getBookId()); // 设置bookid为购物车里面的bookid
            orderItem.setCount(cart.getCount());  // 设置数量为购物车里面的数量
            orderItem.setOrderId(order.getId()); // 设置订单id为订单表对应id
            orderItems.add(orderItem); // 将orderItem添加到orderItems中去
            cartIds.add(cart.getId()); // 将购物车里面的id赋值给cartIds
        }
        orderItemService.saveBatch(orderItems); // 将订单明细逐条插入到订单明细表
        // 3、删除购物车表中的记录
        cartService.removeByIds(cartIds); // 根据id删除当前购物车信息
        return "success";
    }
    /**
     * 查询用户订单
     */
    public List<Order> findUserOrder(Integer userId){
        List<Order> list = orderMapper.findOrderAndOrderDetailListByUser(userId);
        for(Order order: list){
            List<OrderItem> items = order.getOrderItems();
            double price = 0.0;
            for(OrderItem item: items){
                price += item.getCount() * item.getBook().getNewPrice();
            }
            order.setTotalPrice(price);
        }
        return list;
    }
}
