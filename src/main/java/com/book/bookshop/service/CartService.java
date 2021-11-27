package com.book.bookshop.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.bookshop.entity.Cart;
import com.book.bookshop.entity.CartVo;
import com.book.bookshop.entity.UserCartVo;
import com.book.bookshop.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CartService extends ServiceImpl<CartMapper, Cart> {
    @Autowired
    private CartMapper cartMapper;

    /*
    * 根据用户查询购物车记录
    *
    * */
    public List<CartVo> findCartByUser(Integer userId){
        return cartMapper.findCartListByUserId(userId);
    }

    /*
    * 根据购物车id查询对应的记录
    * */
    public List<CartVo> findCartByIds(String ids){
        return cartMapper.findCartListByIds(Arrays.asList(ids));
    }

    /*
    * 统计当前用户购物车的总计
    * */
    public double getCartItemTotal(List<CartVo> list){
        double sum = 0.0;
        for (CartVo cart:list){
            sum += cart.getCount() * cart.getNewPrice();
        }
        return sum;
    }
    /*
    * 批量删除
    * */
    public String batchDelete(String ids){
        if(ids != null){
            String[] idArray = ids.split(",");
            cartMapper.deleteBatchIds(Arrays.asList(idArray));
        }
        return "success";
    }
    /*
    * 包装用户购物车信息数据
    * */
    public UserCartVo wapperCart(List<CartVo> list){
        UserCartVo userCartVo = new UserCartVo();
        userCartVo.setNum(list.size());
        userCartVo.setTotalPrice((getCartItemTotal(list)));
        return userCartVo;
    }

}
