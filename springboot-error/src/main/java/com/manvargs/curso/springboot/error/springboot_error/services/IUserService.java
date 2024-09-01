package com.manvargs.curso.springboot.error.springboot_error.services;

import java.util.List;

import com.manvargs.curso.springboot.error.springboot_error.models.domain.User;

public interface IUserService {

    List<User> findAll();

    User findById(Long id);

}
