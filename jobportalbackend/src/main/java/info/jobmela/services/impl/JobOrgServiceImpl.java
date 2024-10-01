package info.jobmela.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import info.jobmela.entities.JobOrganizations;
import info.jobmela.repositories.JobOrgRepo;
import info.jobmela.services.JobOrgService;

@Service
public class JobOrgServiceImpl implements JobOrgService {
	
	private JobOrgRepo jobOrgRepo;
		

	public JobOrgServiceImpl(JobOrgRepo jobOrgRepo) {
		this.jobOrgRepo = jobOrgRepo;
	}

	@Override
	public JobOrganizations add(JobOrganizations jobOrganizations) {
		JobOrganizations organizations = jobOrgRepo.save(jobOrganizations);
		return organizations;
	}

	@Override
	public List<JobOrganizations> getAll() {
		List<JobOrganizations> jobOrganizations = jobOrgRepo.findAll();
		return jobOrganizations;
	}

}
