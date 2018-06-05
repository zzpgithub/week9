package com.tw.JxMarket.service;

import com.tw.JxMarket.entity.Inventory;
import com.tw.JxMarket.entity.Order;
import com.tw.JxMarket.entity.OrderDetail;
import com.tw.JxMarket.entity.Product;
import com.tw.JxMarket.repository.InventoryRepository;
import com.tw.JxMarket.repository.OrderRepository;
import com.tw.JxMarket.repository.ProductRepository;
import com.tw.JxMarket.service.interfa.OrderServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements OrderServiceInterface{

  @Autowired
  OrderRepository orderRepository;
  @Autowired
  ProductRepository productRepository;
  @Autowired
  InventoryRepository inventoryRepository;


  @Override
  public String addOrder(List<OrderDetail> orderDetails){
    Order order = new Order();
    double totalPrice = createOrderDetailAndCalculateTotalPrice(orderDetails);
    order.setTotalPrice(totalPrice);
    order.setStatus("UNPAID");
    return "Add Order Success.";
  }

  private Double createOrderDetailAndCalculateTotalPrice(List<OrderDetail> orderDetails) {
    double totalPrice = 0.0;
    for (OrderDetail orderDetail : orderDetails) {
      Product product = productRepository.findOne(orderDetail.getProductId());
      Inventory inventory = inventoryRepository.findByProductId(orderDetail.getProductId());
      if(inventory.getCount() - inventory.getLockCount() < orderDetail.getPurchaseCount()){
        System.out.println("product not enough"); ////商品数量不足
      }else{
        inventory.setCount(inventory.getCount()- orderDetail.getPurchaseCount());
        inventoryRepository.saveAndFlush(inventory);
        totalPrice += orderDetail.getPurchaseCount() * product.getPrice();
      }
    }
    return totalPrice;
  }

  @Override
  public Order getOrderByOrderId(long id) {
    return orderRepository.findById(id);
  }
}
