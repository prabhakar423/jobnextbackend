package info.jobmela.repositories;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import info.jobmela.entities.JobAdvertisements;
import info.jobmela.entities.JobPost;

public interface JobPostRepo extends JpaRepository<JobPost, String> {

	List<JobPost> findByJobAdvertisements(JobAdvertisements jobAdvertisements);
	
	@Query("SELECT jp FROM JobPost jp JOIN jp.jobAdvertisements ja " +
	           "JOIN ja.jobOrganizations jo " +
	           "JOIN jo.jobOrganizationCategories joc " +
	           "WHERE joc.jobOrgCategoryId = :categoryId")
	Page<JobPost> findByOrganizationCategory(String categoryId,Pageable pageable);
	
	Page<JobPost> findByJobAdvertisements_JobOrganizations_JobOrganizationCategories_JobOrgCategoryId(String categoryId,Pageable pageable);
	
	Page<JobPost> findByJobAdvertisements_JobOrganizations_JobStateMaster_JobStateId(String stateId,Pageable pageable);
	Page<JobPost> findByJobPostId(String postId,Pageable pageable);
}
