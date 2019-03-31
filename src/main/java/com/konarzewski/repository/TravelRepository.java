package com.konarzewski.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.konarzewski.domain.Profile;
import com.konarzewski.domain.Travel;

public interface TravelRepository extends JpaRepository<Travel, Integer> {
}
