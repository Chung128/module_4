package com.example.quan_li_gio_hang.controller;


import com.example.quan_li_gio_hang.model.Cart;
import com.example.quan_li_gio_hang.model.Product;
import com.example.quan_li_gio_hang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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

    @GetMapping("/{id}/detail")
    public String viewBook(@PathVariable Long id, Model model) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isEmpty()) {
            return "error_404";
        }
        model.addAttribute("product", productOptional.get());
        return "detail";
    }
    @GetMapping("{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){
        productService.remove(id);
        redirectAttributes.addFlashAttribute("success","Đã xóa thành công");
        return "shop";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }


    @GetMapping("{id}/edit")
    public String update(@PathVariable Long id, Model model) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "update";
        } else {
            return "redirect:/shop";
        }
    }


    @PostMapping("update")
    public String update(Product product,RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("success","Cập nhật thành công!");
        return "redirect:/shop";
    }
    @PostMapping("/save")
    public String create(@ModelAttribute Product product,
                         @RequestParam("imageFile") MultipartFile imageFile,
                         RedirectAttributes redirectAttributes) {

        // Nếu người dùng upload file ảnh
        if (!imageFile.isEmpty()) {
            try {
                // Lấy tên file
                String fileName = imageFile.getOriginalFilename();

                // Thư mục bạn muốn lưu ảnh vào (nằm trong static/images/)
                String uploadDir = "src/main/resources/static/images/";

                // Tạo path để lưu ảnh
                Path uploadPath = Paths.get(uploadDir);

                // Tạo thư mục nếu chưa tồn tại
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                // Copy file vào thư mục
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                // Gán tên file ảnh vào thuộc tính image của Product
                product.setImage(fileName);

            } catch (IOException e) {
                e.printStackTrace();
                redirectAttributes.addFlashAttribute("error", "Không thể lưu ảnh: " + e.getMessage());
                return "redirect:/shop";
            }
        }

        // Lưu sản phẩm
        productService.save(product);
        redirectAttributes.addFlashAttribute("success", "Thêm mới thành công!");
        return "redirect:/shop";
    }
}
