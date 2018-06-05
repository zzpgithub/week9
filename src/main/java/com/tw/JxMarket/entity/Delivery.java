package com.tw.JxMarket.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Delivery {
  @Id
  @GeneratedValue
  private Long id;

  private String deliveryStatus;
  private Date deliveryStartTime;
  private Date deliveryEndTime;

  private Long orderId;

  public Delivery(String deliveryStatus, Long orderId) {
    this.deliveryStatus = deliveryStatus;
    this.orderId = orderId;
  }

  @OneToOne(targetEntity = Order.class)
  @JoinColumn(name = "orderId", insertable = false, updatable = false)
  private Order order;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDeliveryStatus() {
    return deliveryStatus;
  }

  public void setDeliveryStatus(String deliveryStatus) {
    this.deliveryStatus = deliveryStatus;
  }

  public Date getDeliveryStartTime() {
    return deliveryStartTime;
  }

  public void setDeliveryStartTime(Date deliveryStartTime) {
    this.deliveryStartTime = deliveryStartTime;
  }

  public Date getDeliveryEndTime() {
    return deliveryEndTime;
  }

  public void setDeliveryEndTime(Date deliveryEndTime) {
    this.deliveryEndTime = deliveryEndTime;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }
}
