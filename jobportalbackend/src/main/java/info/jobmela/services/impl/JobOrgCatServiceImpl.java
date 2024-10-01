package info.jobmela.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import info.jobmela.entities.JobOrganizationCategories;
import info.jobmela.repositories.JobOrgCatRepo;
import info.jobmela.services.JobOrgCatService;

@Service
public class JobOrgCatServiceImpl  implements JobOrgCatService{
	
	private JobOrgCatRepo jobOrgCatRepo;

	public JobOrgCatServiceImpl(JobOrgCatRepo jobOrgCatRepo) {
		this.jobOrgCatRepo = jobOrgCatRepo;
	}


	@Override
	public List<JobOrganizationCategories> getAll() {
		List<JobOrganizationCategories> allCat = jobOrgCatRepo.findAll();
		return allCat;
	}

}
