package com.mehmetaliakar.springbootaccountuserdemo.repository;

import com.mehmetaliakar.springbootaccountuserdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByNameAndSurname(String name, String surname);
}
