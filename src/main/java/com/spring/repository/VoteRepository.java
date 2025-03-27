package com.spring.repository;

import com.spring.model.User;
import com.spring.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
