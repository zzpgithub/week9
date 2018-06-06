package com.tw.JxMarket.service.interfa;

import com.tw.JxMarket.entity.Order;
import com.tw.JxMarket.entity.OrderDetail;
import java.util.List;

public interface OrderServiceInterface {

  String addOrder(List<OrderDetail> orderDetails);

  Order getOrderById(Long id);

  String payOrder(Long id);

  String withdrawOrder(Long id);

  List<Order> getOrdersByUserId(long userId);
}
