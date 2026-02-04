package com.calendar.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 고유 식별자(ID)

    @Column(nullable = false, length = 30) // 최대 30자 이내로 제한, 필수값 처리
    private String title; // 일정 제목

    @Column(nullable = false, length = 200) // 최대 200자 이내로 제한, 필수값 처리
    private String content; // 일정 내용

    @Column(nullable = false) // 필수값 처리
    private String writer; // 작성자명

    @Column(nullable = false) // 필수값 처리
    private String password; // 비밀번호

    public Schedule(String title, String content, String writer, String password) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.password = password;
    }

    public void updateSchedule(String title, String writer) { // 과제의 요구사항: 일정 제목, 작성자명만 수정가능하다를 수용
        this.title = title; // TODO 비밀번호도 요청을 해야하는데 따로 포함하지않아도되나?
//        TODO - Service 로직에서 비밀번호 일치 여부 검증 로직 추가

        this.writer = writer;
    }
}
