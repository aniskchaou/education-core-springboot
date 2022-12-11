package com.dev.delta.services;

import com.dev.delta.entities.User;
import com.dev.delta.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    /**
     * UserRepository
     */
    @Autowired
    private UserRepository UserRepository;


    /**
     * getUsers
     * @return
     */
    public java.util.List<User> getUsers()
    {
        return UserRepository.findAll();
    }

    /**
     * getCount
     * @return
     */
    public long getCount()
    {
        return UserRepository.count();
    }

    /**
     * save
     * @param User
     */
    public void save(User User)
    {
        UserRepository.save(User);
    }

    /**
     * findById
     * @param id
     * @return
     */
    public Optional<User> findById(Long id) {
        return UserRepository.findById(id);
    }

    /**
     * delete
     * @param id
     */
    public void delete(Long id) {
        UserRepository.delete(UserRepository.findById(id).get());
    }
}