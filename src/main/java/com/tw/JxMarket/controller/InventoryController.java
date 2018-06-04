package com.tw.JxMarket.controller;

import com.tw.JxMarket.entity.Inventory;
import com.tw.JxMarket.service.interfa.InventoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/inventories")
public class InventoryController {

  @Autowired
  private InventoryServiceInterface inventoryService;

  @PutMapping(value = "{productId}/{count}")
  @ResponseStatus(HttpStatus.OK)
  Inventory updateProductNumber(@PathVariable Long productId, @PathVariable int count) {
    return inventoryService.updateCount(productId, count);
  }
}
