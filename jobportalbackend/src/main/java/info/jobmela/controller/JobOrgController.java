package info.jobmela.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.jobmela.entities.JobOrganizations;
import info.jobmela.services.JobOrgService;

@RestController
@RequestMapping("/job-org")
public class JobOrgController {
	
	private JobOrgService jobOrgService;
	

	public JobOrgController(JobOrgService jobOrgService) {
		this.jobOrgService = jobOrgService;
	}


	@PostMapping
	public ResponseEntity<JobOrganizations> save(@RequestBody JobOrganizations jobOrganizations){
		JobOrganizations organizations = jobOrgService.add(jobOrganizations);
		return new ResponseEntity<JobOrganizations>(organizations,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<JobOrganizations>> getAll(){
		List<JobOrganizations> all = jobOrgService.getAll();
		return new ResponseEntity<List<JobOrganizations>>(all,HttpStatus.OK);
	}
}
