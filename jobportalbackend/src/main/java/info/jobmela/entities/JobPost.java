package info.jobmela.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "job_post")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JobPost {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String jobPostId;
	private String jobPostHeading;
	private String jobPostName;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime jobPostLastUpdated;
	private int jobPostTotalVacancy;
	private String jobPostBriefInfo;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "job_post_type_id")
	private JobPostTypeMaster jobPostTypeMaster;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime jobPostCreationDate;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime jobPostLastUpdationDate;
	private String jobPostCreatedBy;
	private String jobPostUpdatedBy;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "job_advt_id")	
	private JobAdvertisements jobAdvertisements;
}
