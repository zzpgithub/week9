package com.tw.JxMarket.service;

import com.tw.JxMarket.entity.Delivery;
import com.tw.JxMarket.entity.Inventory;
import com.tw.JxMarket.entity.Order;
import com.tw.JxMarket.entity.OrderDetail;
import com.tw.JxMarket.entity.Product;
import com.tw.JxMarket.repository.DeliveryRepository;
import com.tw.JxMarket.repository.InventoryRepository;
import com.tw.JxMarket.repository.OrderDetailRepository;
import com.tw.JxMarket.repository.OrderRepository;
import com.tw.JxMarket.repository.ProductRepository;
import com.tw.JxMarket.service.interfa.DeliveryServiceInterface;
import com.tw.JxMarket.service.interfa.InventoryServiceInterface;
import com.tw.JxMarket.service.interfa.OrderDetailServiceInterface;
import com.tw.JxMarket.service.interfa.OrderServiceInterface;
import java.util.Date;
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
  InventoryServiceInterface inventoryService;
  @Autowired
  OrderDetailServiceInterface orderDetailService;
  @Autowired
  private DeliveryServiceInterface deliveryService;

  @Override
  public String addOrder(List<OrderDetail> orderDetails){
    Order order = new Order();
    double totalPrice = createOrderDetailAndCalculateTotalPrice(orderDetails);
    order.setTotalPrice(totalPrice);
    order.setStatus("UNPAID");
    Order newOrder = orderRepository.saveAndFlush(order);
    orderDetailService.createOrderDetail(orderDetails,newOrder.getId());
    return "Add Order Success.";
  }

  private Double createOrderDetailAndCalculateTotalPrice(List<OrderDetail> orderDetails) {
    double totalPrice = 0.0;
    for (OrderDetail orderDetail : orderDetails) {
      Product product = productRepository.findOne(orderDetail.getProductId());
      Inventory inventory = inventoryService.getInventoryByProductId(orderDetail.getProductId());
      if(inventory.getCount() - inventory.getLockCount() < orderDetail.getPurchaseCount()){
        System.out.println("product not enough"); ////商品数量不足
      }else{
        inventory.setCount(inventory.getCount()- orderDetail.getPurchaseCount());
        inventoryService.saveInventory(inventory);
        totalPrice += orderDetail.getPurchaseCount() * product.getPrice();
      }
    }
    return totalPrice;
  }

  @Override
  public Order getOrderById(Long id) {
    return orderRepository.findById(id);
  }

  @Override
  public String payOrder(Long id) {
    Order order = orderRepository.findById(id);
    order.setStatus("PAID");
    order.setPaidTime(new Date());
    orderRepository.save(order);

    //delivery
    Delivery delivery = new Delivery();
    delivery.setOrderId(order.getId());
    delivery.setDeliveryStatus("NEED_TO_DELIVERY");
    deliveryService.createDelivery(delivery);
   // Delivery delivery = deliveryRepository.save(new Delivery("NEED_TO_DELIVERY",order.getId()));

    return "Pay Order";
  }

  @Override
  public String withdrawOrder(Long id) {
    Order order = orderRepository.findById(id);
    order.setStatus("WITHDRAW");
    order.setWithdrawTime(new Date());
    orderRepository.save(order);
    inventoryService.updateInventories(order.getPurchaseDetailList());

    return "Withdraw Order";
  }

  @Override
  public List<Order> getOrdersByUserId(long userId) {
    return orderRepository.findByUserId(userId);
  }
}
