package com.geekbrains.ru.springmvcdemo.repository.impl;


import com.geekbrains.ru.springmvcdemo.domain.Product;
import com.geekbrains.ru.springmvcdemo.repository.ProductRepository;
import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Data
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> products = new ArrayList<>();

    @Override
    @PostConstruct
    public void init() {
        products.add(new Product(1, "title", 20.2));
        products.add(new Product(2, "title", 20.2));
        products.add(new Product(3, "title", 20.2));
        products.add(new Product(4, "title", 20.2));
        products.add(new Product(5, "title", 20.2));
    }


    @Override
    public List<Product> findAll() {
        return products;
    }


    @Override
    public Optional<Product> findById(long id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean addProduct(Product product) {
        if (checkForProductAttributes(product)){
            products.add(product);
            return true;
        }
        return false;
    }

    private boolean checkForProductAttributes(Product product) {
        Long id = product.getId();
        Double price = product.getPrice();
        String name = product.getName();
        if (name != null || id != null || price != null){
            return true;
        }
        return false;
    }
}
