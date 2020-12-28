package com.Carina.Blog.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/comment")
@RestController
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<?> CreateComment(@RequestBody Comment c){
        return new ResponseEntity<>(commentService.createComment(c), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getComment() {
        return new ResponseEntity<>(commentService.getComments(), HttpStatus.OK);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<?> updateComment(@PathVariable Long commentId, @RequestBody Comment c){
        Comment updateC = commentService.findComment(commentId);
        updateC.setComentario(c.getComentario());
        return new ResponseEntity<>(commentService.updateComment(updateC), HttpStatus.OK);
    }

    @DeleteMapping ("/{commentId}")
    public ResponseEntity<?> deleteComment (@PathVariable Long commentId) {
        Comment comment = commentService.findComment(commentId);
        commentService.delete(comment);
        return new ResponseEntity<>(HttpStatus.OK); }


    @GetMapping("/post")
    public ResponseEntity<?> getCommentsByPost(@RequestParam Long postId, @RequestParam Integer num) {
        return new ResponseEntity<>(commentService.getCommentsByPost(postId, num), HttpStatus.OK); }
}
