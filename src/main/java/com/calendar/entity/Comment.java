package com.calendar.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "commets")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Commet extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String content;
    private String writer;
    private String password;
    private Long scheduleId;
}

public Cot(String content, String writer, String password, Long scheduleId) {
            this.content = content,
            this.writer = writer,
            this.password = password,
            this.scheduleId = scheduleId;
}
public void
