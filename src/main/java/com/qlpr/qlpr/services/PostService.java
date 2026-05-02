package com.qlpr.qlpr.services;

import com.qlpr.qlpr.entity.Posts;
import com.qlpr.qlpr.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostsRepository postsRepository;

    public List<Posts> getAllPost()
    {
        return postsRepository.findAll();
    }

    public Posts getPostById(int id)
    {
        return postsRepository.findById(id).orElseThrow(()-> new RuntimeException("Post Not Found"));
    }

    public ResponseEntity<String> deletePost(int postId)
    {
//        Posts existingPost = postsRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post Not Found"));
        postsRepository.deleteById(postId);
        return ResponseEntity.status(200).body("Post Deleted");
    }

    public Posts createPost(int userid,  String postContent, String postdate, String textcontent)
    {
        byte[] postContentString = Base64.getDecoder().decode(postContent.split(",")[1]);
        Posts posts = new Posts();
        posts.setUserid(userid);
        posts.setPostcontent(postContentString);
        posts.setLikes(0);
        posts.setPostdate(postdate);
        posts.setTextcontent(textcontent);
        return postsRepository.save(posts);
    }

}
