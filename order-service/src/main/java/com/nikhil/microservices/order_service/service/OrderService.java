package com.nikhil.microservices.order_service.service;

import com.nikhil.microservices.order_service.model.Order;
import com.nikhil.microservices.order_service.repository.OrderRepository;
import com.nikhil.microservices.order_service.request.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){
        // map request to order object
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setQuantity(orderRequest.quantity());
        order.setSkuCode(orderRequest.skuCode());
        // save order to order repository
        orderRepository.save(order);
    }
}
