package info.jobmela.services;

import java.util.List;

import info.jobmela.entities.JobAdvertisements;

public interface JobAdvtService {

	List<JobAdvertisements> getAll();
	
	JobAdvertisements addJobAdvertisements(JobAdvertisements jobAdvertisements);
	
	JobAdvertisements findByAdvtId(String  advtId);
}
