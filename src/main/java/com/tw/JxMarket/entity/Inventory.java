package com.tw.JxMarket.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Inventory {
  @Id
  @GeneratedValue
  private Long id;

  private int count;
  private int lockCount;

  private long productId;

  @OneToOne(cascade= CascadeType.ALL)
  @JoinColumn(name="productId",insertable = false,updatable = false)
  private Product product;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getLockCount() {
    return lockCount;
  }

  public void setLockCount(int lockCount) {
    this.lockCount = lockCount;
  }

  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }
}
