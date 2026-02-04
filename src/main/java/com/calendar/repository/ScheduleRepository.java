package com.calendar.repository;

import com.calendar.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    // 수정일 기준 내림차 정렬
    List<Schedule> findAllByOrderByModifiedAtDesc();
    // 작성자명을 기준으로 등록된 일정 목록을 전부 조회
    List<Schedule> findByWriterOrderByModifiedAtDesc(String writer);
//                 조회하겠다 조건 시작 Writer필드를 정렬하겠다 수정일기준 내림차순으로
}

