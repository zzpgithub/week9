package com.tw.JxMarket.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderDetail {
  @Id
  @GeneratedValue
  private Long id;

  private long productId;

  private int purchaseCount;

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
}
