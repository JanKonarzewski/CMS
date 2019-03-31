package com.konarzewski.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.konarzewski.domain.Accommodation;
import com.konarzewski.domain.Conference;

public interface AccommodationRpository extends JpaRepository<Accommodation, Integer> {
}