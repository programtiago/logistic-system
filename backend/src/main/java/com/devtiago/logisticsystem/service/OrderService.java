package com.devtiago.logisticsystem.service;

import com.devtiago.logisticsystem.domain.Order;
import com.devtiago.logisticsystem.domain.exception.DomainException;
import com.devtiago.logisticsystem.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public Order get(Long orderId){
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new DomainException("Order not found"));
    }

    @Transactional
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Transactional
    public void delete(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
