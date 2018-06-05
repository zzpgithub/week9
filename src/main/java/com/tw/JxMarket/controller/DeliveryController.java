package com.tw.JxMarket.controller;

import com.tw.JxMarket.entity.Delivery;
import com.tw.JxMarket.service.interfa.DeliveryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/deliveries")
public class DeliveryController {
  @Autowired
  DeliveryServiceInterface deliveryService;

  @PutMapping("{id}/{status}")
   String updateDeliveryStatus(@PathVariable long id,@PathVariable String status) {
    if(status.equals("SENDING")){
      return deliveryService.sendDeliveryById(id);
    }else if(status.equals("SIGNED"))
    {
      return deliveryService.signDeliveryById(id);
    }
    return "fail status";
  }

  @GetMapping(value = "{id}")
  @ResponseStatus(HttpStatus.OK)
  Delivery getDeliveryById(@PathVariable Long id) {
    return deliveryService.getDeliveryById(id);
  }
}
