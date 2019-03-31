package com.konarzewski.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.konarzewski.domain.Event;

public interface EventReporitory extends JpaRepository<Event, Integer>{

}
