package com.tw.JxMarket.service.interfa;

import com.tw.JxMarket.entity.Inventory;
import com.tw.JxMarket.entity.OrderDetail;
import java.util.List;

public interface InventoryServiceInterface {
  Inventory updateCount(Long productId, int count);

  Inventory updateLockCount(Long productId, int lockCount);

  Inventory getInventoryByProductId(Long productId);

  Inventory saveInventory(Inventory inventory);

  String updateInventories(List<OrderDetail> orderDetails);
}
