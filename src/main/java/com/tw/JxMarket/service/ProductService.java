package com.tw.JxMarket.service;

import com.tw.JxMarket.entity.Product;
import com.tw.JxMarket.repository.ProductRepository;
import com.tw.JxMarket.service.interfa.ProductServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements ProductServiceInterface{

  @Autowired
  private ProductRepository productRepository;

  @Override
  public Product addProduct(Product product) {
    return productRepository.save(product);
  }

  @Override
  public List<Product> getProductList(){
    return productRepository.findAll();
  }

  @Override
  public Product updateProductById(long id, Product product){
    Product updateProduct = productRepository.findOne(id);
    updateProduct.setName(product.getName());
    updateProduct.setDescription(product.getDescription());
    updateProduct.setPrice(product.getPrice());
    return productRepository.save(updateProduct);
  }
}
