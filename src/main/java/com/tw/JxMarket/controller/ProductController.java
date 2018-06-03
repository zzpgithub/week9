package com.tw.JxMarket.controller;

import com.tw.JxMarket.entity.Product;
import com.tw.JxMarket.service.interfa.ProductServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
  @Autowired
  private ProductServiceInterface productService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  Product addProduct(@RequestBody Product input) {
    return productService.addProduct(input);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  List<Product> getProductList() {
    return productService.getProductList();
  }

  @PutMapping(value = "{id}")
  @ResponseStatus(HttpStatus.OK)
  Product putProduct(@PathVariable long id, @RequestBody Product product ) {
    return productService.updateProductById(id,product);
  }
}
