package com.devtiago.logisticsystem.controller;

import com.devtiago.logisticsystem.domain.Order;
import com.devtiago.logisticsystem.repository.OrderRepository;
import com.devtiago.logisticsystem.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/orders")
public class OrderController {

    private static final Logger LOG = LoggerFactory.getLogger(ClientController.class);

    private final OrderService orderService;
    private final OrderRepository orderRepository;

    public OrderController(OrderService orderService, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<Order> getCategories(){
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> find(@PathVariable Long id){
        return orderRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order add(@Valid @RequestBody Order category){
        return orderService.save(category);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Order> update(@PathVariable Long orderId, @Valid @RequestBody Order order){
        if (!orderRepository.existsById(orderId)){
            return ResponseEntity.notFound().build();
        }

        order.setId(orderId);
        order = orderService.save(order);

        return ResponseEntity.ok(order);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> delete(@PathVariable Long orderId){
        if (!orderRepository.existsById(orderId)){
            return ResponseEntity.notFound().build();
        }

        orderService.delete(orderId);

        return ResponseEntity.noContent().build();
    }
}
