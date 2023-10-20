package com.example.examprepchocho.service.impl;

import com.example.examprepchocho.model.entity.Order;
import com.example.examprepchocho.model.service.OrderServiceModel;
import com.example.examprepchocho.model.view.OrderViewModel;
import com.example.examprepchocho.repository.OrderRepository;
import com.example.examprepchocho.service.CategoryService;
import com.example.examprepchocho.service.OrderService;
import com.example.examprepchocho.service.UserService;
import com.example.examprepchocho.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final CurrentUser currentUser;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository, UserService userService, CurrentUser currentUser, CategoryService categoryService, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.currentUser = currentUser;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }



    @Override
    public void addOrder(OrderServiceModel orderServiceModel) {

        Order order = modelMapper.map(orderServiceModel, Order.class);
        order.setEmployee(userService.findById(currentUser.getId()));
        order.setCategory(categoryService.findByCategoryNameEnum(orderServiceModel.getCategory()));

        orderRepository.save(order);
    }

    @Override
    public List<OrderViewModel> findAllOrderByPriceDesc() {
        return orderRepository
                .findAllByOrderByPriceDesc()
                .stream()
                .map(order -> modelMapper.map(order, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void readyOrder(Long id) {
        orderRepository
                .deleteById(id);
    }
}
