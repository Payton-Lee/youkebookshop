package com.book.bookshop.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.book.bookshop.entity.UserCartVo;
import org.springframework.ui.Model;
import com.book.bookshop.entity.Cart;
import com.book.bookshop.entity.CartVo;
import com.book.bookshop.entity.User;
import com.book.bookshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/*
* 购物车控制器
* */
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    // 加入购物车
    @ResponseBody
    @RequestMapping("/add")
    public String add(Cart cart, HttpSession session) {
        User user = (User) session.getAttribute("user");
        cart.setUserId(user.getId());
        QueryWrapper<Cart> cartQueryWrapper = new QueryWrapper<>();
        cartQueryWrapper.eq("user_id", user.getId());
        cartQueryWrapper.eq("book_id", cart.getBookId());
        Cart queryCart = cartService.getOne(cartQueryWrapper);
        if(queryCart == null){
            cartService.save(cart);
        } else {
            queryCart.setCount(queryCart.getCount() + cart.getCount());
            cartService.updateById(queryCart);
        }
        return "success";
    }

    /*
    * 查询当前用户的购物车
    * */
    @RequestMapping("/list")
    public String list(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        List<CartVo> cartVos = cartService.findCartByUser(user.getId());

        // 将用户的购物车信息存放到session中
        UserCartVo userCartVo = cartService.wapperCart(cartVos);
        session.setAttribute("userCartInfo", userCartVo);

        model.addAttribute("cartList", cartVos);
        return "cart";
    }
    /*
    * 更新购物车信息
    * */
    @ResponseBody
    @RequestMapping("/update")
    public String update(HttpSession session,Cart cart){
        cartService.updateById(cart);
        User user = (User) session.getAttribute("user");
        List<CartVo> cartVos = cartService.findCartByUser(user.getId());

        // 将用户的购物车信息存放到session中
        UserCartVo userCartVo = cartService.wapperCart(cartVos);
        session.setAttribute("userCartInfo", userCartVo);

        double price = cartService.getCartItemTotal(cartVos);
        return String.valueOf(price);
    }
    /*
    * 删除购物车信息
    * */
    @ResponseBody
    @RequestMapping("/delete")
    public String delete(String ids){
        return cartService.batchDelete(ids);
    }
}
