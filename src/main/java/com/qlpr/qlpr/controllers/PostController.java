package com.qlpr.qlpr.controllers;

import com.qlpr.qlpr.entity.Posts;
import com.qlpr.qlpr.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PostController {
    @Autowired
    PostService postService;

    @QueryMapping
    public List<Posts> getAllPost()
    {
        return postService.getAllPost();
    }

    @MutationMapping
    public Posts getPostById(@Argument int postid)
    {
        return postService.getPostById(postid);
    }

    @MutationMapping
    public ResponseEntity<String> deletePost(@Argument int postid)
    {
        return postService.deletePost(postid);
    }

    @MutationMapping
    public Posts createPost(@Argument int userid, @Argument  String postContent,@Argument  String postdate, @Argument String textcontent)
    {
        return postService.createPost(userid, postContent, postdate, textcontent);
    }
}
