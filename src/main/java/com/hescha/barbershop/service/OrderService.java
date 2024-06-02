package com.hescha.barbershop.service;


import com.hescha.barbershop.entity.Order;
import com.hescha.barbershop.repository.OrderRepository;
import org.springframework.stereotype.Service;


@Service
public class OrderService extends CrudImpl<Order> {

    public OrderRepository repository;

    public OrderService(OrderRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
