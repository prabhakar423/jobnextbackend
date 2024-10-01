package info.jobmela.services.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import info.jobmela.dtos.JobPostDto;
import info.jobmela.dtos.PageableResponse;
import info.jobmela.entities.JobAdvertisements;
import info.jobmela.entities.JobOrganizationCategories;
import info.jobmela.entities.JobOrganizations;
import info.jobmela.entities.JobPost;
import info.jobmela.helper.Helper;
import info.jobmela.repositories.JobAdvtRepo;
import info.jobmela.repositories.JobOrgCatRepo;
import info.jobmela.repositories.JobOrgRepo;
import info.jobmela.repositories.JobPostRepo;
import info.jobmela.services.JobPostService;

@Service
public class JobPostServiceImpl implements JobPostService {
	
	private JobPostRepo jobPostRepo;
	
	private JobAdvtRepo jobAdvtRepo;
	
	private JobOrgRepo jobOrgRepo;
	
	private JobOrgCatRepo jobOrgCatRepo;
	
	

	public JobPostServiceImpl(JobPostRepo jobPostRepo, JobAdvtRepo jobAdvtRepo, JobOrgRepo jobOrgRepo,
			JobOrgCatRepo jobOrgCatRepo) {
		this.jobPostRepo = jobPostRepo;
		this.jobAdvtRepo = jobAdvtRepo;
		this.jobOrgRepo = jobOrgRepo;
		this.jobOrgCatRepo = jobOrgCatRepo;
	}


	@Override
	public PageableResponse<JobPostDto> getAll(int pageNumber,int pageSize,String sortBy,String sortDir) {
		Sort sort=(sortDir.equalsIgnoreCase("DESC"))?(Sort.by(sortBy).descending()):(Sort.by(sortBy).ascending());
		Pageable pageable= PageRequest.of(pageNumber, pageSize,sort);
		Page<JobPost> jobs = jobPostRepo.findAll(pageable);
		PageableResponse<JobPostDto> pageableResponse = Helper.getPageableResponse(jobs, JobPostDto.class);
		return pageableResponse;
	}

	@Override
	public JobPost addJobPost(JobPost jobPost) {
		jobPost.setJobPostCreationDate(LocalDateTime.now());
		jobPost.setJobPostLastUpdationDate(LocalDateTime.now());
		JobPost savedPost = jobPostRepo.save(jobPost);
		return savedPost;
	}

	@Override
	public List<JobPost> getByAdvtId(JobAdvertisements jobAdvertisements) {
		List<JobPost> jobPosts = jobPostRepo.findByJobAdvertisements(jobAdvertisements);
		return jobPosts;
	}


	@Override
	public PageableResponse<JobPostDto> getAllByCategory(int pageNumber, int pageSize, String sortBy, String sortDir,
			String categoryId) {
		Sort sort=(sortDir.equalsIgnoreCase("DESC"))?(Sort.by(sortBy).descending()):(Sort.by(sortBy).ascending());
		Pageable pageable= PageRequest.of(pageNumber, pageSize,sort);
		//Page<JobPost> byOrganizationCategory = jobPostRepo.findByOrganizationCategory(categoryId,pageable);
		Page<JobPost> byOrganizationCategory = jobPostRepo.findByJobAdvertisements_JobOrganizations_JobOrganizationCategories_JobOrgCategoryId(categoryId,pageable);
		PageableResponse<JobPostDto> pageableResponse = Helper.getPageableResponse(byOrganizationCategory, JobPostDto.class);
		return pageableResponse;
	}


	@Override
	public PageableResponse<JobPostDto> getAllBystate(int pageNumber, int pageSize, String sortBy, String sortDir,
			String stateId) {
		Sort sort=(sortDir.equalsIgnoreCase("DESC"))?(Sort.by(sortBy).descending()):(Sort.by(sortBy).ascending());
		Pageable pageable= PageRequest.of(pageNumber, pageSize,sort);
		Page<JobPost> byOrganizationCategory = jobPostRepo.findByJobAdvertisements_JobOrganizations_JobStateMaster_JobStateId(stateId, pageable);
		PageableResponse<JobPostDto> pageableResponse = Helper.getPageableResponse(byOrganizationCategory, JobPostDto.class);
		return pageableResponse;
	}
	
	@Override
	public PageableResponse<JobPostDto> findPost(int pageNumber, int pageSize, String sortBy, String sortDir,
			String postId) {
		Sort sort=(sortDir.equalsIgnoreCase("DESC"))?(Sort.by(sortBy).descending()):(Sort.by(sortBy).ascending());
		Pageable pageable= PageRequest.of(pageNumber, pageSize,sort);
		Page<JobPost> byOrganizationCategory = jobPostRepo.findByJobPostId(postId,pageable);
		PageableResponse<JobPostDto> pageableResponse = Helper.getPageableResponse(byOrganizationCategory, JobPostDto.class);
		return pageableResponse;
	}



	

}
