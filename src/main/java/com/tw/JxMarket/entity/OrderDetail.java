package com.tw.JxMarket.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class OrderDetail {
  @Id
  @GeneratedValue
  private Long id;

  private long productId;

  private int purchaseCount;

  private Long orderId;

//  @OneToOne
//  @JoinColumn(name = "productId",insertable = false,updatable = false)
//  @Fetch(FetchMode.JOIN)
//  private Product product;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }

  public int getPurchaseCount() {
    return purchaseCount;
  }

  public void setPurchaseCount(int purchaseCount) {
    this.purchaseCount = purchaseCount;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }
}
