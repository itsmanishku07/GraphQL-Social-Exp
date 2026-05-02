package com.qlpr.qlpr.services;

import com.qlpr.qlpr.entity.Comments;
import com.qlpr.qlpr.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public Comments addComment(int postid, String comment, String commenter, String commentDate)
    {
        Comments comments = new Comments();
        comments.setPostid(postid);
        comments.setCommnet(comment);
        comments.setCommenter(commenter);
        comments.setCommentlikes(0);
        comments.setCommentdate(commentDate);
        commentRepository.save(comments);
        return comments;
    }

    public List<Comments> postComments(int postid)
    {
        return commentRepository.findByPostid(postid);
    }

    public Comments likeComment(int commentID)
    {
        Comments comments = commentRepository.findByCommentid(commentID);
        comments.setCommentlikes(comments.getCommentlikes() + 1);
        commentRepository.save(comments);
        return comments;
    }

    public ResponseEntity<String> deleteComment(int commentID)
    {
        commentRepository.deleteById(commentID);
        return ResponseEntity.status(200).body("Comment Deleted");
    }

}

