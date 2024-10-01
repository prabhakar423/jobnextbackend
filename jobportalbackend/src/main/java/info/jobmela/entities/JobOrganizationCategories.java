package info.jobmela.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "job_organization_categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JobOrganizationCategories {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String jobOrgCategoryId;
	private String jobOrgCategoryName;
//	@OneToOne(mappedBy = "jobOrganizationCategories")
//	private JobOrganizations jobOrganizations;
}
