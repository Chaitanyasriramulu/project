package com.incident.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incident.applicationconstants.ApplicationConstants;

@RestController
public class ApplicationConstantsController {
	
	@GetMapping("/ownerBy")
	public List<String> getOwnerBy(){
		return ApplicationConstants.OwnedBy;
	}
	
	@GetMapping("/priority")
	public List<String> getPriority(){
		return ApplicationConstants.Priority;
	}
	
	@GetMapping("/qaOwner")
	public List<String> getQa_owner(){
		return ApplicationConstants.QAOwner;
	}
	
	
	@GetMapping("/status")
	public List<String> Status(){
		return ApplicationConstants.Status;
	}

}
