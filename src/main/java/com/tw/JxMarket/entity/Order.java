package com.tw.JxMarket.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}