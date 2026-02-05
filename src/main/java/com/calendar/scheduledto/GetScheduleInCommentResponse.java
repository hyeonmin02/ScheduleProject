package com.calendar.scheduledto;

import com.calendar.commentdto.GetCommentResponse;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class GetScheduleInCommentResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final String writer;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final List<GetCommentResponse> commentResponses;


    public GetScheduleInCommentResponse(
            Long id,
            String title,
            String content,
            String writer,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt,
            List<GetCommentResponse> commentResponses
    )
    {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.commentResponses = commentResponses;
    }
}