package com.example.demoshoppingsite.repository;

import com.example.demoshoppingsite.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}
