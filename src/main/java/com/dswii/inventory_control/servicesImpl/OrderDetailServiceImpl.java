package com.dswii.inventory_control.servicesImpl;

import com.dswii.inventory_control.entities.OrderDetail;
import com.dswii.inventory_control.repositories.OrderDetailRepository;
import com.dswii.inventory_control.services.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;

    @Override
    @Transactional
    public List<OrderDetail> findAll() throws Exception {
        try {
            return orderDetailRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public OrderDetail findById(Long id) throws Exception {
        try {
            return orderDetailRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public OrderDetail save(OrderDetail orderDetail) throws Exception {
        try {
            return orderDetailRepository.save(orderDetail);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public OrderDetail update(Long id, OrderDetail orderDetail) throws Exception {
        try {
            boolean isPresent = orderDetailRepository.findById(id).isPresent();
            return isPresent ? orderDetailRepository.save(orderDetail) : null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
