package com.tw.JxMarket.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Double totalPrice;

  private Date paidTime;

  private Date withdrawTime;

  private String status;

  public Order(){}

  @OneToMany
  @JoinColumn(name = "orderId")
  private List<OrderDetail> purchaseDetailList;

  @OneToOne(fetch = FetchType.EAGER, cascade =  CascadeType.REMOVE, mappedBy = "order")
  private Delivery delivery;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public Date getPaidTime() {
    return paidTime;
  }

  public void setPaidTime(Date paidTime) {
    this.paidTime = paidTime;
  }

  public Date getWithdrawTime() {
    return withdrawTime;
  }

  public void setWithdrawTime(Date withdrawTime) {
    this.withdrawTime = withdrawTime;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public List<OrderDetail> getPurchaseDetailList() {
    return purchaseDetailList;
  }

  public void setPurchaseDetailList(List<OrderDetail> purchaseDetailList) {
    this.purchaseDetailList = purchaseDetailList;
  }

  public Delivery getDelivery() {
    return delivery;
  }

  public void setDelivery(Delivery delivery) {
    this.delivery = delivery;
  }
}
