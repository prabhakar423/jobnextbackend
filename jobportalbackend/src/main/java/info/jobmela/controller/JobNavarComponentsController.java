package info.jobmela.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.jobmela.dtos.JobNavbarComponents;
import info.jobmela.entities.JobOrganizationCategories;
import info.jobmela.entities.JobStateMaster;
import info.jobmela.services.JobOrgCatService;
import info.jobmela.services.JobStateMasterService;

@RestController
@RequestMapping("/nav-comp")
@CrossOrigin("*")
public class JobNavarComponentsController {
	
	private JobOrgCatService jobOrgCatService;
	
	private JobStateMasterService jobStateMasterService;
	
	
	public JobNavarComponentsController(JobOrgCatService jobOrgCatService, JobStateMasterService jobStateMasterService) {
		this.jobOrgCatService = jobOrgCatService;
		this.jobStateMasterService = jobStateMasterService;
	}


	@GetMapping
	public ResponseEntity<JobNavbarComponents> get(){
		List<JobStateMaster> allSates = jobStateMasterService.allSates();
		List<JobOrganizationCategories> allOrgCat = jobOrgCatService.getAll();
		JobNavbarComponents jobNavbarComponents = JobNavbarComponents.builder().jobOrgCat(allOrgCat).jobStates(allSates).build();
		return new ResponseEntity<JobNavbarComponents>(jobNavbarComponents,HttpStatus.OK);
	}
}
