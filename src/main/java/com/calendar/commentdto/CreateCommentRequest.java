package com.calendar.commetdto;

import lombok.Getter;

@Getter
public class CreateCommentRequest {
    private Long scheduleId;
    private String content;
    private String writer;
    private String password;
}
