package org.example.vylko.pp_3_1_1_springboot.service;

import org.example.vylko.pp_3_1_1_springboot.entity.User;

import java.util.List;

public interface UserService {
    User findById(Long id);

    void save(User user);

    void delete(Long id);

    void update(User user);

    List<User> findAll();
}
