package com.example.ed.controllecrs;

import com.example.ed.entities.Configurations;
import com.example.ed.entities.Orders;
import com.example.ed.entities.Payment;
import com.example.ed.entities.Products;
import com.example.ed.models.OrderModel;
import com.example.ed.models.PaymentModel;
import com.example.ed.models.ProductModel;
import com.example.ed.services.ConfigurationService;
import com.example.ed.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {
    private ProductService productService;
    private ConfigurationService configurationService;

    public ProductController(ProductService productService, ConfigurationService configurationService) {
        this.productService = productService;
        this.configurationService = configurationService;
    }

    @GetMapping("getAllProducts")
    public ResponseEntity<List<Products>> getProducts(){
        List<Products> products=productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @PostMapping("createProduct")
    public ResponseEntity<Products> createProduct(@RequestBody ProductModel product){
        Products product_=productService.createProduct(product);
        return new ResponseEntity<>(product_,HttpStatus.CREATED);
    }
    @PostMapping("updateProduct")
    public ResponseEntity<Products> createProduct(@RequestBody Products product){
        productService.saveProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    //configurations
    @GetMapping("getAllConfigs")
    public ResponseEntity<List<Configurations>> getConfigs(){
        List<Configurations> configurations=configurationService.getAllConfigs();
        return new ResponseEntity<>(configurations, HttpStatus.OK);
    }
    @PostMapping("createConfig")
    public ResponseEntity<Configurations> createProduct(@RequestBody Configurations configuration_){
        Configurations configuration=configurationService.createConfig(configuration_);
        return new ResponseEntity<>(configuration,HttpStatus.CREATED);
    }
    //Orders
    @GetMapping("getAllOrder")
    public ResponseEntity<List<Orders>> getOrders(){
        List<Orders> orders=productService.getAllOrder();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    @PostMapping("createOrder")
    public ResponseEntity<Orders> createProduct(@RequestBody OrderModel order_){
        Orders order=productService.processOrder(order_);
        return new ResponseEntity<>(order,HttpStatus.CREATED);
    }
    @PostMapping("customPayment")
    public ResponseEntity<PaymentModel> createProduct(@RequestBody PaymentModel paymentModel){
        PaymentModel payment=productService.makePayment(paymentModel);
        return new ResponseEntity<>(payment,HttpStatus.CREATED);
    }
    @PostMapping("findPaymentById")
    public ResponseEntity<Payment> findPaymentById(@RequestBody Long id){
        Payment payment=productService.findPaymentById(id);
        return new ResponseEntity<>(payment,HttpStatus.CREATED);
    }
    @PostMapping("findPaymentByRef")
    public ResponseEntity<Payment> findPaymentByRef(@RequestBody String ref){
        Payment payment=productService.findPaymentByRef(ref).get();
        return new ResponseEntity<>(payment,HttpStatus.CREATED);
    }
    @GetMapping("findAllPayment")
    public ResponseEntity<List<Payment>> findAllPayment(){
        List<Payment> payment=productService.findAllPayments();
        return new ResponseEntity<>(payment,HttpStatus.CREATED);
    }


}
