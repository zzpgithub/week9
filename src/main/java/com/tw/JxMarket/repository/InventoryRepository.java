package com.tw.JxMarket.repository;

import com.tw.JxMarket.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
  Inventory findByProductId(Long productId);
}
