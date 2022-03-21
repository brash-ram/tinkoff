package com.tinkoff.repository;

import com.tinkoff.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
	Request findById(long id);
}