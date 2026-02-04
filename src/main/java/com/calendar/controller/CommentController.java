package com.calendar.controller;

import com.calendar.service.CommetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class CommetController {
    private final CommetService commetService;

    @PutMapping()


}
