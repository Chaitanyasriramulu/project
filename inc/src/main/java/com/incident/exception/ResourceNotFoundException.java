package com.incident.exception;

public class ResourceNotFoundException extends RuntimeException {
	
private static final long serialVersionUID=1L;
private String resourceName;
private String fieldName;
private Object fieldValue;


public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
	super(" A Resource with name : " + resourceName + " not found with " + fieldName + " : " + fieldValue.toString()
);
	this.resourceName = resourceName;
	this.fieldName = fieldName;
	this.fieldValue = fieldValue;
}


public String getResourceName() {
	return resourceName;
}


public String getFieldName() {
	return fieldName;
}



public Object getFieldValue() {
	return fieldValue;
}



}

