package com.incident.service;

import java.util.List;

import com.incident.dto.Incident;



public interface IncidentService {
	
	Long saveIncident(Incident incident);
	List<Incident> getAllIncidents();
	Incident getIncidentById(long id);
	Incident updateIncident(Incident incident, long id);
	void deleteIncident(long id);
}
