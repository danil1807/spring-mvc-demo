package com.geekbrains.ru.springmvcdemo.repository;


import com.geekbrains.ru.springmvcdemo.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void init();

    List<Product> findAll();

    Optional<Product> findById(long id);

    boolean addProduct(Product product);
}
