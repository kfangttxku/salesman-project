package th.ac.ku.salesman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.salesman.model.Order;
import th.ac.ku.salesman.service.OrdersService;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    private OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping
    public String getOrdersPage(Model model) {
        model.addAttribute("allOrders", ordersService.getOrders());
        return "orders";
    }

    @PostMapping
    public String registerOrders(@ModelAttribute Order order, Model model) {
        ordersService.createOrder(order);
        model.addAttribute("allOrders", ordersService.getOrders());
        return "redirect:orders";
    }

    @GetMapping("/delete/{id}")
    public String getDeleteProductPage(@PathVariable int id, Model model) {
        Order order = ordersService.getOneOrder(id);
        model.addAttribute("orders", order);
        return "orders-delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id, @ModelAttribute Order order, Model model) {
        ordersService.deleteOrder(order);
        model.addAttribute("orders",ordersService.getOrders());
        return "redirect:/orders";
    }
}
