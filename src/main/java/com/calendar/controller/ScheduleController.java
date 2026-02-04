package com.calendar.controller;

import com.calendar.dto.*;

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
    public ResponseEntity<CreateScheduleResponse> createSchedule(@RequestBody CreateScheduleRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.save(request));
    }

    @GetMapping("/schedules") // 전체 일정 조회  @PathVariable과 @RequestBody 필요없음
    public ResponseEntity<List<GetScheduleResponse>> getSchedules() {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.findAll());
    } //TODO -1.작성자명`을 기준으로 등록된 일정 목록을 전부 조회 /`작성자명`은 조회 조건으로 포함될 수도 있고, 포함되지 않을 수도 있음 3.수정일 기준 내림차순으로 정렬

    @GetMapping("/schedules/{scheduleId}") // 선택 일정 조회
    public ResponseEntity<GetScheduleResponse> getScheduleOne(@PathVariable Long scheduleId) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.findOne(scheduleId));
    }

    @PutMapping("/schedules/{scheduleId}") // 선택한 일정 수정
    public ResponseEntity<UpdateScheduleResponse> updateScheduleOne
            (@PathVariable Long scheduleId,
             @RequestBody UpdateScheduleRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.updateSchedule(scheduleId,request));
    }

    @DeleteMapping("/schedules/{scheduleId}") // 선택한 일정 삭제
    public ResponseEntity<Void>deleteScheduleOne(
            @PathVariable Long scheduleId,
            @RequestBody DeleteScheduleRequest request)
    { scheduleService.delete(scheduleId, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
