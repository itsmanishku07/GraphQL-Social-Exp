package com.qlpr.qlpr.repository;

import com.qlpr.qlpr.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Integer> {

    Users findByUsername(String username);
}
