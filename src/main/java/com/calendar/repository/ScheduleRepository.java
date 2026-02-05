package com.calendar.repository;

import com.calendar.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    // 수정일 기준 내림차 정렬
    List<Schedule> findAllByOrderByModifiedAtDesc();
    // 작성자명을 기준으로 등록된 일정 목록을 전부 조회
    List<Schedule> findByWriterOrderByModifiedAtDesc(String writer);
    // 메서드명을 길게 쓰는 이유? Spring Data JPA는 메서드 이름을 분석해 자동으로 SQL을 생성한다.
    // !JPA는 메서드 이름을 기준으로 SQL을 생성하므로,조회 조건과 정렬을 메서드명에 명확히 드러내는 것이 좋다!
    // findByWriter로도 조회는 가능하지만,
    // 정렬이 필요한 경우 DB에서 처리하도록 메서드명에 OrderBy를 명시하는 것이 좋다.
}

