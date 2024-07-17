package com.sunil.validation.service;

import com.sunil.validation.dto.UserRequest;
import com.sunil.validation.entity.Users;
import com.sunil.validation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Users saveUser(UserRequest userRequest
    ) {
        Users user = Users.build(0, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
        return repository.save(user);
    }

    public List<Users> getAllUsers() {
        return repository.findAll();
    }

    public Users getUser(int id) {
        return repository.findByUserId(id);
    }

}
