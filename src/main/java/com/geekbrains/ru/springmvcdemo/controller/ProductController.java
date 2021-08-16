package com.geekbrains.ru.springmvcdemo.controller;

import com.geekbrains.ru.springmvcdemo.domain.Product;
import com.geekbrains.ru.springmvcdemo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product")
    public String getProducts(Model model) {
        List<Product> products = productService.findAll();

        model.addAttribute("products", products);

        return "products";
    }

    @PostMapping("/product")
    public String addProduct(@RequestParam Long id,
                             @RequestParam String name,
                             @RequestParam Double price,
                             Model model) {

        Product product = new Product(id, name, price);
        model.addAttribute("products", product);
        productService.addProduct(product);
        return "redirect:/product";
    }

}
