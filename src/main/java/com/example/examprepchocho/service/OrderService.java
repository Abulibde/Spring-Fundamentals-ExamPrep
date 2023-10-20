package com.example.examprepchocho.service;

import com.example.examprepchocho.model.service.OrderServiceModel;
import com.example.examprepchocho.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel map);

    List<OrderViewModel> findAllOrderByPriceDesc();

    void readyOrder(Long id);
}
