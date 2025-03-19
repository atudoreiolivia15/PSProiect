package com.spring.repository;

import com.spring.model.Comment;
import com.spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
