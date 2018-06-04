package com.tw.JxMarket.service.interfa;

import com.tw.JxMarket.entity.Product;
import java.util.List;

public interface ProductServiceInterface {
  Product addProduct(Product product);

  List<Product> getProductList();

  Product updateProductById(long id, Product employee);

  Product getProductById(Long id);

  List<Product> getProductsByNameAndDescription(String name, String description);

}
