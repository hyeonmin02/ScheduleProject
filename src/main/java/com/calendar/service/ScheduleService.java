package com.calendar.service;

import com.calendar.dto.CreateScheduleRequest;
import com.calendar.dto.CreateScheduleResponse;
import com.calendar.entity.Schedule;
import com.calendar.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
