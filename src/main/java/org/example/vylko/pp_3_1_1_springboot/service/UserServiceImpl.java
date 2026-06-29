package org.example.vylko.pp_3_1_1_springboot.service;

import org.example.vylko.pp_3_1_1_springboot.dao.UserDAO;
import org.example.vylko.pp_3_1_1_springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(Long id) {
        return userDAO.findById(id);
    }

    @Transactional
    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userDAO.delete(id);
    }

    @Transactional
    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }
}
