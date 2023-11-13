package com.dswii.inventory_control.servicesImpl;

import com.dswii.inventory_control.entities.Order;
import com.dswii.inventory_control.repositories.OrderRepository;
import com.dswii.inventory_control.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public List<Order> findAll() throws Exception {
        try {
            return orderRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Order findById(Long id) throws Exception {
        try {
            return orderRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Order save(Order order) throws Exception {
        try {
            return orderRepository.save(order);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Order update(Long id, Order order) throws Exception {
        try {
            boolean isPresent = orderRepository.findById(id).isPresent();
            return isPresent ? orderRepository.save(order) : null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
