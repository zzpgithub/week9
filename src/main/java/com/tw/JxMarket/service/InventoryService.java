package com.tw.JxMarket.service;

import com.tw.JxMarket.entity.Inventory;
import com.tw.JxMarket.entity.OrderDetail;
import com.tw.JxMarket.repository.InventoryRepository;
import com.tw.JxMarket.service.interfa.InventoryServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService implements InventoryServiceInterface{
  @Autowired
  InventoryRepository inventoryRepository;

  @Override
  public Inventory updateCount(Long productId, int count){
    Inventory updateInventory = inventoryRepository.findByProductId(productId);
    updateInventory.setCount(count);
    return inventoryRepository.save(updateInventory);
  }

  @Override
  public Inventory updateLockCount(Long productId, int lockCount){
    Inventory updateInventory = inventoryRepository.findByProductId(productId);
    updateInventory.setCount(lockCount);
    return inventoryRepository.save(updateInventory);
  }

  @Override
  public Inventory getInventoryByProductId(Long productId){
    return inventoryRepository.findByProductId(productId);
  }

  @Override
  public Inventory saveInventory(Inventory inventory) {
    return inventoryRepository.saveAndFlush(inventory);
  }

  @Override
  public String updateInventories(List<OrderDetail> orderDetails) {
    for (OrderDetail orderDetail: orderDetails) {
      Inventory inventory = getInventoryByProductId(orderDetail.getProductId());
      //inventory.setLockCount();
      inventory.setCount(inventory.getCount() + orderDetail.getPurchaseCount());
      saveInventory(inventory);
    }
    return "Update Inventories";
  }
}
