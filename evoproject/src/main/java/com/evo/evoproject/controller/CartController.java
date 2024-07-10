package com.evo.evoproject.controller;

import com.evo.evoproject.model.Cart;
import com.evo.evoproject.service.CartService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/cart")
public class CartController {

    private static final Logger log = Logger.getLogger(CartController.class.getName());

    @Autowired
    private CartService cartService;

    //장바구니 전체 상품 조회
    @GetMapping("/{userNo}")
    public String viewCart(@PathVariable int userNo, HttpSession session) {
        List<Cart> cartItems = cartService.getCartItemsByUser(userNo);
        // 모든 장바구니 항목을 세션에 저장
        session.setAttribute("cartItems", cartItems);

        return "cart";
    }


    // 장바구니에서 상품 제거
    @DeleteMapping("/delete")
    @ResponseBody
    public String deleteProductFromCart(@RequestParam int userNo, @RequestParam int proNo) {
        cartService.deleteProductFromCart(userNo, proNo);
        log.info("장바구니에서 상품이 제거되었습니다. 상품 번호: " + proNo);
        return "장바구니에서 상품이 제거되었습니다";
    }
}