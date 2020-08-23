package com.example.servingwebcontent.repositories;

import com.example.servingwebcontent.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}