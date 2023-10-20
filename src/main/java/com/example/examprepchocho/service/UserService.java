package com.example.examprepchocho.service;

import com.example.examprepchocho.model.entity.User;
import com.example.examprepchocho.model.service.UserServiceModel;
import com.example.examprepchocho.model.view.UserViewModel;

import java.util.List;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findById(Long id);

    List<UserViewModel> findAllUserAndCountOfOrdersOrderByCountDesc();
}
