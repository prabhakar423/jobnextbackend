package info.jobmela.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import info.jobmela.entities.JobAdvertisements;
import info.jobmela.entities.JobOrganizations;

public interface JobAdvtRepo extends JpaRepository<JobAdvertisements, String> {


}
