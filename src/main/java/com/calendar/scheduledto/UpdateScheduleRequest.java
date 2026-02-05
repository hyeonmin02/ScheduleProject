package com.calendar.scheduledto;

import lombok.Getter;

@Getter
public class UpdateScheduleRequest { // 선택한 일정 내용 중 일정 제목, 작성자명만 수정 가능
    private String title; // 수정할 일정 제목
    private String writer; // 수정할 작성자명
    private String password; // 검증용 (저장X)

}