package com.dswii.inventory_control.services;

import com.dswii.inventory_control.entities.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> findAll() throws Exception;
    OrderDetail findById(Long id) throws Exception;
    OrderDetail save(OrderDetail orderDetail) throws Exception;
    OrderDetail update(Long id, OrderDetail orderDetail) throws Exception;
}
