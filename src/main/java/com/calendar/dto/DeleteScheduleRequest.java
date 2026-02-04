package com.calendar.dto;

import lombok.Getter;

@Getter
public class DeleteRequest { // Path 고유아이디만 입력해도 삭제되니까 따로 추가 x 서버에 일정 삭제을 요청할 때 비밀번호를 함께 전달
    private String password;
}
