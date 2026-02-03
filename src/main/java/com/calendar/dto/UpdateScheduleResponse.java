package com.calendar.dto;

import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class UpdateScheduleResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final String writer;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public UpdateScheduleResponse(
            Long id,
            String title,
            String content,
            String writer,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt
    )
    {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
//    - []  **선택한 일정 수정**
//    - []  선택한 일정 내용 중 `일정 제목`, `작성자명`만 수정 가능
//        - []  서버에 일정 수정을 요청할 때 `비밀번호`를 함께 전달합니다.
//        - []  `작성일`은 변경할 수 없으며, `수정일`은 수정 완료 시, 수정한 시점으로 변경되어야 합니다.
//    - []  API 응답에 `비밀번호`는 제외해야 합니다.