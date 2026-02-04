package com.calendar.service;

import com.calendar.repository.CommetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class CommetService {
    private final CommetRepository commetRepository;
}
