package com.incident.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.incident.dto.Incident;
import com.incident.repository.IncidentRepository;



@Service
public class IncidentServiceImpl implements IncidentService {
	
	@Autowired
	private IncidentRepository incRepo;

	
	@Override
	public Long saveIncident(Incident inc) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	      Date date1;
		try {
			date1 = sdf.parse(inc.getDueDate());
			if(date1.before(new Date())){
				
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Current and Past date can't be given.");
				
			}
		} catch (ParseException e1) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Date must be yyyy-mm-dd format.");
		}
		
	      
		
		com.example.demo.entity.Incident incident = new com.example.demo.entity.Incident();
		
		incident.setSummary(inc.getSummary());
		incident.setStatus(inc.getStatus());
		incident.setOwnedBy(inc.getOwnedBy());
		incident.setQaOwner(inc.getQaOwner());
		incident.setPriority(inc.getPriority());
		incident.setCreationDate(new Date());
		incident.setCreatedBy(inc.getCreatedBy());
		incident.setDueDate(inc.getDueDate());
		incident.setDescription(inc.getDescription());

		return incRepo.save(incident).getId();
		
	}

	@Override
	public List<Incident> getAllIncidents() {
		List<com.example.demo.entity.Incident> incidentEntityList = incRepo.findAll();
		List<Incident> incidentList = new ArrayList<>();
	
		if(incidentEntityList != null && incidentEntityList.size()>0) {
			for(com.example.demo.entity.Incident incidentEntity:incidentEntityList) {
				Incident inc = mapIncidentEntityToDto(incidentEntity);
				
				incidentList.add(inc);

			}
			
		}
		
		return incidentList;
	
	}

	private Incident mapIncidentEntityToDto(com.example.demo.entity.Incident incidentEntity) {
		Incident inc = new Incident();
		inc.setId(incidentEntity.getId());
		inc.setSummary(incidentEntity.getSummary());
		inc.setStatus(incidentEntity.getStatus());
		inc.setOwnedBy(incidentEntity.getOwnedBy());
		inc.setQaOwner(incidentEntity.getQaOwner());
		inc.setPriority(incidentEntity.getPriority());
		inc.setCreationDate(incidentEntity.getCreationDate());
		inc.setCreatedBy(incidentEntity.getCreatedBy());
		inc.setDueDate(incidentEntity.getDueDate());
		inc.setDescription(incidentEntity.getDescription());
		return inc;
	}

	@Override
	public Incident getIncidentById(long id) {
		Optional<com.example.demo.entity.Incident> inc = incRepo.findById(id);
		
		if (inc.isPresent())
		{
			Incident inc1 = mapIncidentEntityToDto(inc.get());
	
			return inc1;
		} else {
			throw new ResourceNotFoundException("Incident", "id", id);
		}
	}

	@Override
	public Incident updateIncident(Incident incident, long id) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	      Date date2;
		try {
			date2 = sdf.parse(incident.getDueDate());
			if(date2.before(new Date())){
				
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Current and Past date can't be given.");
				
			}
		} catch (ParseException e1) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Date must be yyyy-mm-dd format.");
		}
		
		Optional<com.example.demo.entity.Incident> existingIncident = incRepo.findById(id);
		if (!existingIncident.isPresent()) {
			throw new ResourceNotFoundException("Incident", "id", id);
		}

		com.example.demo.entity.Incident updateInc = existingIncident.get();
		if (!StringUtils.equalsIgnoreCase(updateInc.getCreatedBy(),incident.getCreatedBy())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"This field can't be edited");

		}
	
		updateInc.setSummary(incident.getSummary());
		updateInc.setStatus(incident.getStatus());
		updateInc.setDescription(incident.getDescription());
		updateInc.setCreatedBy(incident.getCreatedBy());
		updateInc.setQaOwner(incident.getQaOwner());
		updateInc.setPriority(incident.getPriority());
		updateInc.setDueDate(incident.getDueDate());
		
		com.example.demo.entity.Incident updatedIncident=incRepo.save(updateInc);
		
		Incident inc1 = mapIncidentEntityToDto(updatedIncident);


		return inc1;
	}

	@Override
	public void deleteIncident(long id) {
		Optional<com.example.demo.entity.Incident> inc = incRepo.findById(id);
		if (inc.isPresent()) {
			incRepo.deleteById(id);
		} else {
			throw new ResourceNotFoundException("Incident", "id", id);
		}

	}

}