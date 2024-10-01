package info.jobmela.services;

import java.util.List;

import info.jobmela.dtos.JobPostDto;
import info.jobmela.dtos.PageableResponse;
import info.jobmela.entities.JobAdvertisements;
import info.jobmela.entities.JobPost;

public interface JobPostService {

	PageableResponse<JobPostDto> getAll(int pageNumber,int pageSize,String sortBy,String sortDir);
	
	JobPost addJobPost(JobPost jobPost);
	
	List<JobPost> getByAdvtId(JobAdvertisements jobAdvertisements);
	
	PageableResponse<JobPostDto> getAllByCategory(int pageNumber, int pageSize, String sortBy, String sortDir,
			String categoryId);
	
	PageableResponse<JobPostDto> getAllBystate(int pageNumber, int pageSize, String sortBy, String sortDir,
			String stateId);
	
	PageableResponse<JobPostDto> findPost(int pageNumber, int pageSize, String sortBy, String sortDir,
			String postId);
}
