package com.calendar.controller;

import com.calendar.dto.CreateScheduleRequest;
import com.calendar.dto.CreateScheduleResponse;

import com.calendar.dto.GetScheduleResponse;
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
    }

    @GetMapping("/schedules/{scheduleId}") // 선택 일정 조회
    public ResponseEntity<GetScheduleResponse> getScheduleOne(@PathVariable Long scheduleId) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.findOne(scheduleId));
    }
}
