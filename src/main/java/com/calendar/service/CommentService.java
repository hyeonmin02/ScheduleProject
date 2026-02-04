package com.calendar.service;

import com.calendar.commentdto.CreateCommentRequest;
import com.calendar.commentdto.CreateCommentResponse;
import com.calendar.entity.Comment;
import com.calendar.repository.CommentRepository;
import com.calendar.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    public CreateCommentResponse createComment(CreateCommentRequest request) {
        Long scheduleId = request.getScheduleId();
        if (!scheduleRepository.existsById(scheduleId)) {
            throw new IllegalStateException("없는 일정입니다.");
        }

        long commentCount = commentRepository.countByScheduleId(scheduleId);
        if (commentCount >= 10) {
            throw new IllegalStateException("댓글은 10개까지만 작성 가능하십니다.");
        }

        Comment comment = new Comment(
                request.getScheduleId(),
                request.getContent(),
                request.getWriter(),
                request.getPassword()
        );

        Comment savedComment = commentRepository.save(comment);
        return new CreateCommentResponse(
                savedComment.getId(),
                savedComment.getScheduleId(),
                savedComment.getContent(),
                savedComment.getWriter(),
                savedComment.getCreatedAt(),
                savedComment.getModifiedAt()
        );
    }

}
