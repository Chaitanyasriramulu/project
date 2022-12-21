package com.incident.applicationconstants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ApplicationConstants {
	public static final List<String> OwnedBy = Collections.unmodifiableList(
		    Arrays.asList("Omkar", "Srini", "Suresh","Chandra", "Swamy"));
	public static final List<String> QAOwner = Collections.unmodifiableList(
		    Arrays.asList("Srikanth", "Uday", "Ram prasad","Ratnam", "Sekar"));
	public static final List<String> Priority = Collections.unmodifiableList(
		    Arrays.asList("Critical", "High", "Medium","Low"));
	public static final List<String> Status = Collections.unmodifiableList(
		    Arrays.asList("New", "OwnedBy-In-Progress","OwnedBy-Closed","QA-In-Progress","QA-Closed","Closed"));

}
