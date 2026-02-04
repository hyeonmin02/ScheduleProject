package com.calendar.service;

import com.calendar.dto.*;
import com.calendar.entity.Schedule;
import com.calendar.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    // 일정 생성 메서드
    public CreateScheduleResponse createSchedule(CreateScheduleRequest request) {
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContent(),
                request.getWriter(),
                request.getPassword()
        );
        System.out.println(schedule.getId());
        Schedule savedSchedule = scheduleRepository.save(schedule);
        System.out.println(savedSchedule.getId());

        return new CreateScheduleResponse(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getContent(),
                savedSchedule.getWriter(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );
    }

    // 전체 일정 조회 메서드 (작성자명을 기준으로 등록된 일정 목록을 전부 조회 추가)
    @Transactional(readOnly = true)
    public List<GetScheduleResponse> getSchedules(String writer) {
        // DB에서 Schedule 엔티티 목록을 가져올 변수
        List<Schedule> schedules;
        // writer가 없으면 "전체조회", 있으면 "writer 조건 조회"
        if (writer == null || writer.isBlank()) {
            schedules = scheduleRepository.findAllByOrderByModifiedAtDesc();
        } else {
            schedules = scheduleRepository.findByWriterOrderByModifiedAtDesc(writer);
        }
        // Schedule(엔티티) 목록을 GetScheduleResponse(DTO) 목록으로 바꾸기
        List<GetScheduleResponse> dtos = new ArrayList<>();

        for (Schedule schedule : schedules) {
            GetScheduleResponse dto = new GetScheduleResponse(
                    schedule.getId(),
                    schedule.getTitle(),
                    schedule.getContent(),
                    schedule.getWriter(),
                    schedule.getCreatedAt(),
                    schedule.getModifiedAt()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    // 선택 일정 조회 메서드
    @Transactional(readOnly = true)
    public GetScheduleResponse getSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalStateException("없는 일정입니다."));
        return new GetScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getWriter(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    // 선택 일정 수정 메서드
    public UpdateScheduleResponse updateSchedule(Long scheduleId, UpdateScheduleRequest request) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalStateException("없는 일정입니다."));
        // 비밀번호 일치 여부 검증 로직 추가
        if (!schedule.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지않습니다.");
        }
        // 과제의 요구사항 : 일정제목, 작성자명만 수정가능
        schedule.updateSchedule(request.getTitle(), request.getWriter());
        // 응답을 다시 Controller로 돌려줌
        return new UpdateScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getWriter(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    // 선택 일정 삭제 메서드
    public void deleteSchedule(Long scheduleId, DeleteScheduleRequest request) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalStateException("없는 일정입니다."));
        // 비밀번호 일치 여부 검증 로직 추가
        if (!schedule.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지않습니다.");
        }
        scheduleRepository.deleteById(scheduleId); // 삭제
    }
}


