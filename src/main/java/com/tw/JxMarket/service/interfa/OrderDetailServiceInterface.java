package com.tw.JxMarket.service.interfa;

import com.tw.JxMarket.entity.OrderDetail;
import java.util.List;

public interface OrderDetailServiceInterface {
  String createOrderDetail(List<OrderDetail> orderDetails, Long OrderId);
}
