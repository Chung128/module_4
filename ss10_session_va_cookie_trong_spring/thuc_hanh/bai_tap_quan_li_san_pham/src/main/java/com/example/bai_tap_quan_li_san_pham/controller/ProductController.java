package com.example.bai_tap_quan_li_san_pham.controller;


import com.example.bai_tap_quan_li_san_pham.model.Cart;
import com.example.bai_tap_quan_li_san_pham.model.Product;
import com.example.bai_tap_quan_li_san_pham.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class ProductController {

    private IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }


    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("")
    public String showShop(Model model) {
        model.addAttribute("products", productService.findAll());
        return "shop";
    }


    @GetMapping("/shopping")
    public String showCart(@SessionAttribute Cart cart, Model model) {
        model.addAttribute("cart", cart); // quan trọng
        return "cart"; // trả về cart.html
    }

    @PostMapping("")
    public String processCart(@ModelAttribute Cart cart, Model model) {
        model.addAttribute("cart", cart);
        return "cart";
    }
    @GetMapping("/reduce/{id}")
    public String reduceProduct(@PathVariable Long id,
                                @ModelAttribute Cart cart,
                                @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error_404";
        }

        Product product = productOptional.get();

        // Giảm số lượng nếu tồn tại
        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                int currentQty = entry.getValue();
                if (currentQty > 1) {
                    cart.getProducts().put(entry.getKey(), currentQty - 1);
                } else {
                    cart.getProducts().remove(entry.getKey()); // xóa khỏi giỏ nếu còn 1
                }
                break;
            }
        }
        return action.equals("show") ? "redirect:/shop/shopping" : "redirect:/shop";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error_404";
        }
        cart.addProduct(productOptional.get());
        if ("show".equals(action)) {
            return "redirect:/shop/shopping";
        }
        return "redirect:/shop";
    }
}
