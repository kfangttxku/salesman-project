package th.ac.ku.salesman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.salesman.model.Product;
import th.ac.ku.salesman.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getProductPage(Model model) {
        model.addAttribute("allProducts", productService.getProduct());
        return "product";
    }

    @PostMapping
    public String registerProduct(@ModelAttribute Product product, Model model) {
        productService.createProduct(product);
        model.addAttribute("allProducts", productService.getProduct());
        return "redirect:product";
    }

    @GetMapping("/delete/{productId}")
    public String getDeleteProductPage(@PathVariable int productId, Model model) {
        Product product = productService.getOneProduct(productId);
        model.addAttribute("product", product);
        return "product-delete";
    }

    @PostMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable int productId, @ModelAttribute Product product, Model model) {
        productService.deleteProduct(product);
        model.addAttribute("allProducts",productService.getProduct());
        return "product";
    }

}
