package com.konarzewski.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.konarzewski.domain.Conference;


public interface ConferenceRepository extends CrudRepository<Conference, Integer> {
	
	
	@Query(value = "SELECT * FROM conference c WHERE c.name LIKE %:pattern%", nativeQuery = true)
	Collection<Conference> findAllConferenceByName(@Param("pattern") String namePattern);
	
}