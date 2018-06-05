package com.tw.JxMarket.service.interfa;

import com.tw.JxMarket.entity.Delivery;

public interface DeliveryServiceInterface {

  Delivery getDeliveryById(long id);

  String sendDeliveryById(long id);

  String signDeliveryById(long id);
}
