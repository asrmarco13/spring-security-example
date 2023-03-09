package it.example.securityexample.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.example.securityexample.model.Users;
import it.example.securityexample.repositories.UserRepository;

/**
 * *Author: Marco Orfei
 * *The Class UserService
 */
@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Users> userList() {
        return userRepository.findAll();
    }

}
