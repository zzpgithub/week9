package com.tw.JxMarket.repository;

import com.tw.JxMarket.entity.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
  Order findById(long id);

  List<Order> findByUserId(long userId);
}
