package com.calendar.controller;

import com.calendar.commentdto.CreateCommentRequest;
import com.calendar.commentdto.CreateCommentResponse;
import com.calendar.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    //댓글 생성
    @PostMapping("/comments")
    public ResponseEntity<CreateCommentResponse> create(@RequestBody CreateCommentRequest request)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.createComment(request));
    }
}

