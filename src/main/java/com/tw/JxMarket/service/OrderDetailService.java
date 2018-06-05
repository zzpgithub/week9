package com.tw.JxMarket.service;

import com.tw.JxMarket.entity.OrderDetail;
import com.tw.JxMarket.repository.OrderDetailRepository;
import com.tw.JxMarket.service.interfa.OrderDetailServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService implements OrderDetailServiceInterface{

  @Autowired
  OrderDetailRepository orderDetailRepository;

  @Override
  public  String createOrderDetail(List<OrderDetail> orderDetails, Long orderId) {
    for (OrderDetail orderDetail: orderDetails) {
      orderDetail.setOrderId(orderId);
      orderDetailRepository.save(orderDetail);
    }
    return "add orderDetail success";
  }

}
