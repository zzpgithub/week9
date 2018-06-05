package com.tw.JxMarket.service.interfa;

import com.tw.JxMarket.entity.Order;
import com.tw.JxMarket.entity.OrderDetail;
import java.util.List;

public interface OrderServiceInterface {

  String addOrder(List<OrderDetail> orderDetails);

  Order getOrderByOrderId(long id);

}
