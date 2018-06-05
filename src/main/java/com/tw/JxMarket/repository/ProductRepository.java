package com.tw.JxMarket.repository;

import com.tw.JxMarket.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  Product findById(Long id);

  List<Product> findByNameOrDescriptionContaining(String name, String description);
}
