package com.calendar.repository;

import com.calendar.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    long countByScheduleId(Long scheduleId); // 일정별 댓글 개수 제한 검증로직
    List<Comment> findAllByScheduleIdOrderByCreatedAtAsc(Long scheduleId);
}   // 일정에 달린 모든 댓글을 작성된 시간(CreatedAt)을 기준으로 오래된 것부터 가져와라
    // 명시된 정렬기준은 없었지만 정렬해주지 않으면 DB 조회 결과의 순서가 보장되지 않기 때문에 생성일 기준 오름차순으로 정렬
