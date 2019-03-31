package com.konarzewski.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.konarzewski.domain.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Integer> {
	Profile findByEmail(String email);
	
//	@Query(value = "SELECT * FROM profile p WHERE p. LIKE %:pattern%", nativeQuery = true)
//	Collection<Conference> findAllUsers(@Param("id") int id);

	@Query(value = "SELECT * FROM profile", nativeQuery = true)
	Collection<Profile> findAllUsers();

}
