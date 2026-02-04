package com.calendar.repository;

import com.calendar.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommetRepository extends JpaRepository<Comment, Long> {
}
