package th.ac.ku.salesman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.salesman.model.Customer;
import th.ac.ku.salesman.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String getCustomerPage(Model model) {
        model.addAttribute("allCustomers", customerService.getCustomer());
        return "customer";
    }

    @PostMapping
    public String registerCustomer(@ModelAttribute Customer customer, Model model) {
        customerService.createCustomer(customer);
        model.addAttribute("allCustomers", customerService.getCustomer());
        return "redirect:customer";
    }

    @GetMapping("/delete/{customerId}")
    public String getDeleteCustomerPage(@PathVariable int customerId, Model model) {
        Customer customer = customerService.getOneCustomer(customerId);
        model.addAttribute("customer", customer);
        return "customer-delete";
    }

    @PostMapping("/delete/{customerId}")
    public String deleteCustomer(@PathVariable int customerId, @ModelAttribute Customer customer, Model model) {
        customerService.deleteCustomer(customer);
        model.addAttribute("allCustomers",customerService.getCustomer());
        return "customer";
    }


}

