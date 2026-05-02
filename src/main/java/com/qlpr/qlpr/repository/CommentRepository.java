package com.qlpr.qlpr.repository;

import com.qlpr.qlpr.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comments,Integer> {

    Comments findByCommentid(int commentid);
    List<Comments> findByPostid(int postid);
}

