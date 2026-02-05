package com.calendar.controller;

import com.calendar.scheduledto.*;

import com.calendar.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("/schedules") // 일정 생성
    public ResponseEntity<CreateScheduleResponse> createSchedule(@RequestBody CreateScheduleRequest request)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.createSchedule(request));
    }

    @GetMapping("/schedules") // 전체 일정 조회 URL에 writer라는 값이 잇으면 받아서 쓰고 아니면 null로 둬라
    public ResponseEntity<List<GetScheduleResponse>> getSchedules(@RequestParam(required = false) String writer)
    {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getSchedules(writer));
    }

    @GetMapping("/schedules/{scheduleId}") // 선택 일정 조회
    public ResponseEntity<GetScheduleInCommentResponse> getSchedule(@PathVariable Long scheduleId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getSchedule(scheduleId));
    }

    @PatchMapping("/schedules/{scheduleId}") // 선택 일정 수정
    public ResponseEntity<UpdateScheduleResponse> updateSchedule(
            @PathVariable Long scheduleId,
             @RequestBody UpdateScheduleRequest request)
    {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.updateSchedule(scheduleId, request));
    }

    @DeleteMapping("/schedules/{scheduleId}") // 선택 일정 삭제
    public ResponseEntity<Void> deleteSchedule(
            @PathVariable Long scheduleId,
            @RequestBody DeleteScheduleRequest request)
    {
        scheduleService.deleteSchedule(scheduleId, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
