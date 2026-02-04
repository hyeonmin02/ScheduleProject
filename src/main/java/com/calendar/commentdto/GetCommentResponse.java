package com.calendar.commentdto;
//- [ ]  **일정 단건 조회 업그레이드**
//    - [ ]  일정 단건 조회 시, 해당 일정에 등록된 댓글들을 포함하여 함께 응답합니다.
//    - [ ]  API 응답에 `비밀번호`는 제외해야 합니다.

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetCommentResponse {
    private final Long id;
    private final Long scheduleId;
    private final String content;
    private final String writer;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public GetCommentResponse(Long id, Long scheduleId, String content, String writer, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.scheduleId = scheduleId;
        this.content = content;
        this.writer = writer;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
