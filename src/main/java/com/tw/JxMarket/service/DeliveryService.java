package com.tw.JxMarket.service;

import com.tw.JxMarket.entity.Delivery;
import com.tw.JxMarket.repository.DeliveryRepository;
import com.tw.JxMarket.service.interfa.DeliveryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class DeliveryService implements DeliveryServiceInterface{

  @Autowired
  DeliveryRepository deliveryRepository;

  @Override
  public String createDelivery(Delivery delivery) {
    deliveryRepository.saveAndFlush(delivery);
    return "Create Delivery";
  }

  @Override
  public Delivery getDeliveryById(long id){
    return  deliveryRepository.findById(id);  ////bug
  }

  @Override
  public String sendDeliveryById(long id){
    Delivery delivery = deliveryRepository.findById(id);  ////bug
    delivery.setDeliveryStartTime(new Date());
    delivery.setDeliveryStatus("SENDING");
    deliveryRepository.save(delivery);
    return "SENDING";
  }

  @Override
  public String signDeliveryById(long id){
    Delivery delivery = deliveryRepository.findById(id);   ////bug
    delivery.setDeliveryEndTime(new Date());
    delivery.setDeliveryStatus("SIGNED");
    deliveryRepository.save(delivery);
    return "SIGNED";
  }
}
