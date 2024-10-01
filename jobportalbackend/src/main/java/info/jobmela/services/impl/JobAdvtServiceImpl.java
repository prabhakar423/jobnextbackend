package info.jobmela.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import info.jobmela.entities.JobAdvertisements;
import info.jobmela.repositories.JobAdvtRepo;
import info.jobmela.services.JobAdvtService;

@Service
public class JobAdvtServiceImpl implements JobAdvtService {

	private JobAdvtRepo jobAdvtRepo;
	
	
	public JobAdvtServiceImpl(JobAdvtRepo jobAdvtRepo) {
		this.jobAdvtRepo = jobAdvtRepo;
	}

	@Override
	public List<JobAdvertisements> getAll() {
		List<JobAdvertisements> allJobAdvt = jobAdvtRepo.findAll();
		return allJobAdvt;
	}

	@Override
	public JobAdvertisements addJobAdvertisements(JobAdvertisements jobAdvertisements) {
		JobAdvertisements savedJobAdvt = jobAdvtRepo.save(jobAdvertisements);
		return savedJobAdvt;
	}

	@Override
	public JobAdvertisements findByAdvtId(String advtId) {
		JobAdvertisements jobAdvertisements = jobAdvtRepo.findById(advtId).orElse(null);
		return jobAdvertisements;
	}

}
