package info.jobmela.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import info.jobmela.entities.JobStateMaster;
import info.jobmela.repositories.JobStateMasterRepo;
import info.jobmela.services.JobStateMasterService;

@Service
public class JobStateMasterServiceImpl implements JobStateMasterService {

	private JobStateMasterRepo jobStateMasterRepo;
	
	public JobStateMasterServiceImpl(JobStateMasterRepo jobStateMasterRepo) {
		this.jobStateMasterRepo = jobStateMasterRepo;
	}



	@Override
	public List<JobStateMaster> allSates() {
		List<JobStateMaster> allStates = jobStateMasterRepo.findAll();
		return allStates;
	}

}
