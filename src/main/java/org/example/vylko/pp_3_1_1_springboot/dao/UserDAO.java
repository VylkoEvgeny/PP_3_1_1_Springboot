package org.example.vylko.pp_3_1_1_springboot.dao;


import org.example.vylko.pp_3_1_1_springboot.entity.User;

import java.util.List;

public interface UserDAO {
    User findById(Long id);

    void save(User user);

    void update(User user);

    void delete(Long id);

    List<User> findAll();
}
