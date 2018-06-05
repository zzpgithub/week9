package com.tw.JxMarket.service.interfa;

import com.tw.JxMarket.entity.Inventory;

public interface InventoryServiceInterface {
  Inventory updateCount(Long productId, int count);

  Inventory updateLockCount(Long productId, int lockCount);

  Inventory getInventoryByProductId(Long productId);
}
