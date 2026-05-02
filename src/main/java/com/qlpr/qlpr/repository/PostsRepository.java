package com.qlpr.qlpr.repository;

import com.qlpr.qlpr.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Integer> {
}
