package com.tw.JxMarket.service;

import com.tw.JxMarket.entity.Inventory;
import com.tw.JxMarket.repository.InventoryRepository;
import com.tw.JxMarket.service.interfa.InventoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService implements InventoryServiceInterface{
  @Autowired
  InventoryRepository inventoryRepository;

  ///修改库存
  @Override
  public Inventory updateCount(Long productId, int count){
    Inventory updateInventory = inventoryRepository.findByProductId(productId);
    updateInventory.setCount(count);
    return inventoryRepository.save(updateInventory);
  }

  ///锁定库存
  @Override
  public Inventory updateLockCount(Long productId, int lockCount){
    Inventory updateInventory = inventoryRepository.findByProductId(productId);
    updateInventory.setCount(lockCount);
    return inventoryRepository.save(updateInventory);
  }
}
