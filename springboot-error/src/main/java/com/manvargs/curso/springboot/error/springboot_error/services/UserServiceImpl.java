package com.manvargs.curso.springboot.error.springboot_error.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.manvargs.curso.springboot.error.springboot_error.models.domain.User;

@Service
public class UserServiceImpl implements IUserService {

    private List<User> users;

    public UserServiceImpl() {
        this.users = new ArrayList<>();
        
        users.add(new User(1L, "Pepe", "González"));
        users.add(new User(2L, "Andrés", "Mena"));
        users.add(new User(3L, "María", "Pérez"));
        users.add(new User(4L, "Josefa", "Ramírez"));
        users.add(new User(5L, "Ale", "Gutierrez"));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(Long id) {
        User user = null;

        for (User u : users) {
            if (u.getId().equals(id)) {
                user = u;
                break;
            }
        }

        return user;
    }

}
