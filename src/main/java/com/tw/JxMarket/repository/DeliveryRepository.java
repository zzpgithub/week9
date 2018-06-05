package com.tw.JxMarket.repository;

import com.tw.JxMarket.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
  //Delivery findByOrderId(long orderId);

  Delivery findById(long id);
}
