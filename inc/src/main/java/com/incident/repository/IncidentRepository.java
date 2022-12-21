package com.incident.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRepository extends JpaRepository<com.incident.entity.Incident, Long> {
	 Optional<com.incident.entity.Incident> findById(Long id); 
		
	

}

