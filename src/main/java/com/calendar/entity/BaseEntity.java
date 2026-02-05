package com.calendar.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)

public abstract class BaseEntity {

    @CreatedDate // 최초 저장 시점 자동세팅
    @Column(updatable = false) // 업데이트 시 변경 금지
    private LocalDateTime createdAt; // 작성일 (LocatDateTime) 날짜와 시간을 모두 포함한 형태

    @LastModifiedDate // 엔티티에 변경이 발생해 UPDATE가 실제로 나가야 갱신
    private LocalDateTime modifiedAt; // 수정일
}

