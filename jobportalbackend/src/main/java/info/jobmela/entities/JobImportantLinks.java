package info.jobmela.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "job_important_links")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JobImportantLinks {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String jobImpLinkId;
	private String jobImpApplicationLink;
	private String jobImpNotificationLink;
	private String jobImpExamPatternLink;
	private String jobImpSyllabusLink;
	private String jobImpEligibilityLink;
	private String jobImpOfficialWebsiteLink;
	@OneToOne(mappedBy = "jobImportantLinks")
	@JsonIgnore
	private JobAdvertisements jobAdvertisements;
}
