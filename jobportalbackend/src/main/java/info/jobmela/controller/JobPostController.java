package info.jobmela.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import info.jobmela.dtos.JobPostDto;
import info.jobmela.dtos.PageableResponse;
import info.jobmela.entities.JobAdvertisements;
import info.jobmela.entities.JobPost;
import info.jobmela.services.JobAdvtService;
import info.jobmela.services.JobPostService;

@RestController
@RequestMapping("/job-posts")
@CrossOrigin("*")
public class JobPostController {
	
	private JobPostService jobPostService;
	
	private JobAdvtService jobAdvtService;

	public JobPostController(JobPostService jobPostService,JobAdvtService jobAdvtService ) {
		this.jobPostService = jobPostService;
		this.jobAdvtService = jobAdvtService;
	}

	@GetMapping
	public ResponseEntity<PageableResponse<JobPostDto>> getAll(
			@RequestParam(value = "pageNumber",defaultValue = "0",required = false) int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20",required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "jobPostLastUpdationDate",required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "DESC", required = false) String sortDir
			){
		PageableResponse<JobPostDto> jobPosts = jobPostService.getAll(pageNumber,pageSize,sortBy,sortDir);
		return new ResponseEntity<>(jobPosts,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<JobPost> addJobPost(@RequestBody JobPost jobPost){
		JobPost jobPosts = jobPostService.addJobPost(jobPost);
		return new ResponseEntity<>(jobPosts,HttpStatus.OK);
	}
	
	@GetMapping("/advt/{advtId}")
	public ResponseEntity<List<JobPost>> getPostByAdvt(@PathVariable String advtId){
		JobAdvertisements jobAdvertisements = jobAdvtService.findByAdvtId(advtId);
		List<JobPost> jobPosts = jobPostService.getByAdvtId(jobAdvertisements);
		return new ResponseEntity<>(jobPosts,HttpStatus.OK);
	}
	

	@GetMapping("/org-type/{categoryId}")
	public ResponseEntity<PageableResponse<JobPostDto>> getAllByCategory(
			@RequestParam(value = "pageNumber",defaultValue = "0",required = false) int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20",required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "jobPostLastUpdationDate",required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "DESC", required = false) String sortDir,
			@PathVariable String categoryId
			){
		PageableResponse<JobPostDto> jobPosts = jobPostService.getAllByCategory(pageNumber,pageSize,sortBy,sortDir,categoryId);
		return new ResponseEntity<>(jobPosts,HttpStatus.OK);
	}
	@GetMapping("/state/{stateId}")
	public ResponseEntity<PageableResponse<JobPostDto>> getAllByState(
			@RequestParam(value = "pageNumber",defaultValue = "0",required = false) int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20",required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "jobPostLastUpdationDate",required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "DESC", required = false) String sortDir,
			@PathVariable String stateId
			){
		PageableResponse<JobPostDto> jobPosts = jobPostService.getAllBystate(pageNumber, pageSize, sortBy, sortDir, stateId);
		return new ResponseEntity<>(jobPosts,HttpStatus.OK);
	}
	
	@GetMapping("/{postId}")
	public ResponseEntity<PageableResponse<JobPostDto>> getPostById(
			@RequestParam(value = "pageNumber",defaultValue = "0",required = false) int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20",required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "jobPostLastUpdationDate",required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "DESC", required = false) String sortDir,
			@PathVariable String postId
			){
		PageableResponse<JobPostDto> jobPosts = jobPostService.findPost(pageNumber, pageSize, sortBy, sortDir, postId);
		return new ResponseEntity<>(jobPosts,HttpStatus.OK);
	}
	
}
