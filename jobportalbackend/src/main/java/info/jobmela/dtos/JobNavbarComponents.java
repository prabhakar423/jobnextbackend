package info.jobmela.dtos;

import java.util.ArrayList;
import java.util.List;

import info.jobmela.entities.JobOrganizationCategories;
import info.jobmela.entities.JobStateMaster;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JobNavbarComponents {

	private List<JobOrganizationCategories> jobOrgCat = new ArrayList<>();
	
	private List<JobStateMaster> jobStates = new ArrayList<>();
		
	
}
