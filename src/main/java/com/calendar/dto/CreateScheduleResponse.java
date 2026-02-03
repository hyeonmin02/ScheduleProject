package com.calendar.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final String writer;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CreateScheduleResponse( // API 응답에 `비밀번호` 제외
            Long id,
            String title,
            String content,
            String writer,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt
    ) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
