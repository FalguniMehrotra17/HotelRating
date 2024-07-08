package com.userservice1.UserService1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice1.UserService1.User;

public interface UserRepository extends JpaRepository<User,String>{

}
