package info.jobmela.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import info.jobmela.entities.JobOrganizationCategories;

public interface JobOrgCatRepo extends JpaRepository<JobOrganizationCategories, String> {

}
