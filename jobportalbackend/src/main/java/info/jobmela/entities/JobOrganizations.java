package info.jobmela.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "job_organizations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JobOrganizations {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String jobOrgId;
	private String jobOrgName;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "job_org_category_id")
	private JobOrganizationCategories jobOrganizationCategories;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "job_state_id")
	private JobStateMaster jobStateMaster;
//	@OneToOne(mappedBy = "jobOrganizations")
//	private JobAdvertisements jobAdvertisements;
}
