package com.example.ed.services;

import com.example.ed.entities.Orders;
import com.example.ed.entities.Products;
import com.example.ed.models.OrderModel;
import com.example.ed.models.ProductModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Products> getAllProducts();

    Products createProduct(ProductModel product);

    List<Orders> getAllOrder();

    Orders processOrder(OrderModel order_);
}