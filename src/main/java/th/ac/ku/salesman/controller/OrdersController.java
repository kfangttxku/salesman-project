package th.ac.ku.salesman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.salesman.model.Orders;
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
    public String registerOrders(@ModelAttribute Orders orders, Model model) {
        ordersService.createOrder(orders);
        model.addAttribute("allOrders", ordersService.getOrders());
        return "redirect:orders";
    }
    @GetMapping("/edit/{orderId}")
    public String getEditOrdersPage(@PathVariable int orderId, Model model) {
        Orders orders = ordersService.getOneOrder(orderId);
        model.addAttribute("orders", orders);
        return "orders-edit";
    }
    @PostMapping("/edit/{orderId}")
    public String editorders(@PathVariable int orderId,
                             @ModelAttribute Orders orders,
                             Model model) {

        ordersService.editOrder(orders);
        model.addAttribute("products",ordersService.getOrders());
        return "redirect:/orders";
    }

    @GetMapping("/delete/{orderId}")
    public String getDeleteOrderPage(@PathVariable int orderId, Model model) {
        Orders orders = ordersService.getOneOrder(orderId);
        model.addAttribute("orders", orders);
        return "orders-delete";
    }

    @PostMapping("/delete/{orderId}")
    public String deleteProduct(@PathVariable int orderId, @ModelAttribute Orders orders, Model model) {
        ordersService.deleteOrder(orders);
        model.addAttribute("allOrders",ordersService.getOrders());
        return "orders";
    }
}
