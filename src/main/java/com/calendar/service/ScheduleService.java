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

    public CreateScheduleResponse save(CreateScheduleRequest request) {
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContent(),
                request.getWriter(),
                request.getPassword()
        );
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new CreateScheduleResponse(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getContent(),
                savedSchedule.getWriter(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<GetScheduleResponse> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();

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

    @Transactional(readOnly = true)
    public GetScheduleResponse findOne(Long scheduleId) {
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

    public UpdateScheduleResponse updateSchedule(Long scheduleId, UpdateScheduleRequest request) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalStateException("없는 일정입니다."));

        if (!schedule.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지않습니다.");
            // TODO IllegalArgumentExcepton과 IllegalStateException의 차이가 뭐죠?
        } // 비밀번호 일치 여부 검증 로직 추가

        schedule.updateSchedule( // TODO 요구수정내용 제외한 값을 수정할 시 예외처리
                request.getTitle(), // 과제의 요구사항 : 일정제목, 작성자명만 수정가능
                request.getWriter()
        );
        //TODO 과제 요구사항에 일정 제목, 작성자명만 수정가능하고 비밀번호를 제외한다른 내용은 응답으로 받지않으면 안된단 말이 없는데 보통은 id만 보여주는게 맞는건가여?
        return new UpdateScheduleResponse( // 응답을 다시 Controller로 돌려줌
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getWriter(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    public void delete(Long scheduleId, DeleteScheduleRequest request) { // 인스턴스 Jackson이나 Spring으로만들어준 것
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalStateException("없는 일정입니다."));

        if (!schedule.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지않습니다.");
        } // 비밀번호 일치 여부 검증 로직 추가
        scheduleRepository.deleteById(scheduleId); // 삭제
    }
}

//        boolean existence = scheduleRepository.existsById(scheduleId);
//        if (!existence) {
//            throw new IllegalStateException("없는 일정입니다.");
//        }
//
//        Schedule schedule = scheduleRepository.existsById(scheduleId);
//      DB에서 꺼내온 엔티티 객체(인스턴스) =
//        if (!schedule.getPassword().equals(request.getPassword())) {
//            throw new IllegalArgumentException("비밀번호가 일치하지않습니다.");
//        }


