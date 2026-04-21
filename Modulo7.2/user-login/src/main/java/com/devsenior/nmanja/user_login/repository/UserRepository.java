package com.devsenior.nmanja.user_login.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.devsenior.nmanja.user_login.model.entity.User;

public interface UserRepository extends JpaRepository<User,String>{
    

}
