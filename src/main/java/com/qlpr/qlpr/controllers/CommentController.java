package com.qlpr.qlpr.controllers;

import com.qlpr.qlpr.entity.Comments;
import com.qlpr.qlpr.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @MutationMapping
    public Comments addComment(@Argument int postid, @Argument String comment,@Argument String commenter, @Argument String commentDate)
    {
        return commentService.addComment(postid, comment, commenter, commentDate);
    }

    @QueryMapping
    public List<Comments> postComments(@Argument int postid)
    {
        return commentService.postComments(postid);
    }

    @MutationMapping
    public Comments likeComment(@Argument int commentid)
    {
        return commentService.likeComment(commentid);
    }

    @MutationMapping
    public ResponseEntity<String> deleteComment(@Argument int commentid)
    {
        return commentService.deleteComment(commentid);
    }
}



