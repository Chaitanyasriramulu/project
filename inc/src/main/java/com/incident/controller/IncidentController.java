package com.incident.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incident.entity.Incident;
import com.incident.service.IncService;

@RestController
@RequestMapping("/api/incident")
public class IncidentController {

	@Autowired
	private IncidentService incidentService;

	
	@PostMapping
	public ResponseEntity<Long> saveIncident(@RequestBody Incident inc){
		return new ResponseEntity<Long>(incidentService.saveIncident(inc), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Incident> getAllIncidents(){
		return incidentService.getAllIncidents();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Incident> getIncidentById(@PathVariable("id") long id){
		return new ResponseEntity<Incident>(incidentService.getIncidentById(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Incident> updateIncident(@PathVariable("id") long id, @RequestBody Incident inc){
		return new ResponseEntity<Incident>(incidentService.updateIncident(inc, id), HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteIncident(@PathVariable("id") long id){
		incidentService.deleteIncident(id);
		return new ResponseEntity<String>("Incident Closed", HttpStatus.OK);
	}
	
}
