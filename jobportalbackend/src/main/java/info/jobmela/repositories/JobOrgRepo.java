package info.jobmela.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import info.jobmela.entities.JobOrganizationCategories;
import info.jobmela.entities.JobOrganizations;

public interface JobOrgRepo extends JpaRepository<JobOrganizations, String> {

	List<JobOrganizations> findByJobOrganizationCategories(JobOrganizationCategories jobOrganizationCategories);

}
