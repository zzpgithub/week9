package com.tw.JxMarket.controller;

import com.tw.JxMarket.entity.Order;
import com.tw.JxMarket.entity.OrderDetail;
import com.tw.JxMarket.service.interfa.OrderServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
public class OrderController {
  @Autowired
  private OrderServiceInterface orderService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  String createOrder(@RequestBody List<OrderDetail> orderDetails) {
    return orderService.addOrder(orderDetails);
  }

  @GetMapping(value = "{id}")
  @ResponseStatus(HttpStatus.OK)
  Order getOrderById(@PathVariable long id) {
    return orderService.getOrderById(id);
  }

  @PutMapping(value = "{id}/paid")
  @ResponseStatus(HttpStatus.OK)
  String payOrder(@PathVariable Long id) {
    return orderService.payOrder(id);
  }

  @PutMapping(value = "{id}/withdraw")
  @ResponseStatus(HttpStatus.OK)
  String withdrawOrder(@PathVariable Long id) {
    return orderService.withdrawOrder(id);
  }
}
