package info.jobmela.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import info.jobmela.entities.JobStateMaster;

public interface JobStateMasterRepo extends JpaRepository<JobStateMaster, String> {

}
