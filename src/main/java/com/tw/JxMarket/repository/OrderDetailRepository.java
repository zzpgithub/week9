package com.tw.JxMarket.repository;

import com.tw.JxMarket.entity.OrderDetail;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository  extends JpaRepository<OrderDetail, Long> {

}
