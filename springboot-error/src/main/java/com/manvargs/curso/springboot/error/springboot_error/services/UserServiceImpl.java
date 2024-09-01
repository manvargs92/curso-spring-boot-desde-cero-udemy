package com.manvargs.curso.springboot.error.springboot_error.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.manvargs.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
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

//    @Override
//    public User findById(Long id) {
//        User user = null;
//
//        for (User u : users) {
//            if (u.getId().equals(id)) {
//                user = u;
//                break;
//            }
//        }
//
//        if (user == null) {
//            throw new UserNotFoundException("Error el usuario no existe.");
//        }
//
//        return user;
//    }

    @Override
    public Optional<User> findById(Long id) {



        User user = null;

        for (User u : users) {
            if (u.getId().equals(id)) {
                user = u;
                break;
            }
        }

        return Optional.ofNullable(user); // si lo encuentra devolverá un optional del objeto User; si no lo encuentra devolverá un Optional EMPTY
    }

}
