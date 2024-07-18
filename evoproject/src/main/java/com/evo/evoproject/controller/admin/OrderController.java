package com.evo.evoproject.controller.admin;

import com.evo.evoproject.service.order.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/admin/manageOrder/{status}")
    public String getOrdersByStatus(@PathVariable int status, Model model) {
        List<Order> orders = orderService.getOrdersByStatus(status);

        model.addAttribute("orders", orders);
        model.addAttribute("selectedStatus", status);
        model.addAttribute("countPending", orderService.countOrdersByStatus(0));
        model.addAttribute("countPreparing", orderService.countOrdersByStatus(1));
        model.addAttribute("countShipping", orderService.countOrdersByStatus(2));
        model.addAttribute("countRequest", orderService.countOrdersByStatus(3));
        model.addAttribute("countCompleted", orderService.countOrdersByStatus(4));
        return "/admin/manageOrder";
    }

    @GetMapping("/admin/manageOrder")
    public String getAllOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();

        model.addAttribute("orders", orders);
        model.addAttribute("selectedStatus", "all");
        model.addAttribute("countPending", orderService.countOrdersByStatus(0));
        model.addAttribute("countPreparing", orderService.countOrdersByStatus(1));
        model.addAttribute("countShipping", orderService.countOrdersByStatus(2));
        model.addAttribute("countRequest", orderService.countOrdersByStatus(3));
        model.addAttribute("countCompleted", orderService.countOrdersByStatus(4));
        return "/admin/manageOrder";
    }

    @PostMapping("/admin/manageOrder/{orderNo}/{status}")
    public String updateOrderStatus(@PathVariable int orderNo, @PathVariable int status, @RequestParam("prevStatus") String prevStatus) {
        orderService.updateOrderStatus(orderNo, status);
        if ("all".equals(prevStatus)) {
            return "redirect:/admin/manageOrder";
        } else {
            return "redirect:/admin/manageOrder/" + prevStatus;
        }
    }

    @PostMapping("/admin/manageOrder/{orderNo}/{status}/orderDelivnum")
    public String updateDelivnum(@PathVariable int orderNo, @PathVariable int status, @RequestParam String orderDelivnum, @RequestParam("prevStatus") String prevStatus) {
        orderService.updateDelivnum(orderNo, orderDelivnum);
        orderService.updateOrderStatus(orderNo, status);
        if ("all".equals(prevStatus)) {
            return "redirect:/admin/manageOrder";
        } else {
            return "redirect:/admin/manageOrder/" + prevStatus;
        }
    }

    @PostMapping("/admin/manageOrder/{orderNo}/requestType/{requestType}")
    public String updateRequestType(@PathVariable int orderNo, @PathVariable int requestType, @RequestParam("prevStatus") String prevStatus) {
        orderService.updateRequestType(orderNo, requestType);
        if ("all".equals(prevStatus)) {
            return "redirect:/admin/manageOrder";
        } else {
            return "redirect:/admin/manageOrder/" + prevStatus;
        }
    }

}