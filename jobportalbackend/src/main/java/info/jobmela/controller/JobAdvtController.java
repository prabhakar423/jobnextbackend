package info.jobmela.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.jobmela.entities.JobAdvertisements;
import info.jobmela.services.JobAdvtService;

@RestController
@RequestMapping("/job-advts")
public class JobAdvtController {

	private JobAdvtService jobAdvtService;

	public JobAdvtController(JobAdvtService jobAdvtService) {
		this.jobAdvtService = jobAdvtService;
	}
	
	@GetMapping
	public ResponseEntity<List<JobAdvertisements>> getAll(){
		List<JobAdvertisements> jobAdvts = jobAdvtService.getAll();
		return new ResponseEntity<>(jobAdvts,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<JobAdvertisements> addJobPost(@RequestBody JobAdvertisements jobAdvertisements){
		JobAdvertisements jobAdvts = jobAdvtService.addJobAdvertisements(jobAdvertisements);
		return new ResponseEntity<>(jobAdvts,HttpStatus.OK);
	}
}
