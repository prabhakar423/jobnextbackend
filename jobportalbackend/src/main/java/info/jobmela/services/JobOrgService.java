package info.jobmela.services;

import java.util.List;

import info.jobmela.entities.JobOrganizations;

public interface JobOrgService {

	JobOrganizations add(JobOrganizations jobOrganizations);
	
	List<JobOrganizations> getAll();
}
