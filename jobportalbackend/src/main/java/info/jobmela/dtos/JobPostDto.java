package info.jobmela.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import info.jobmela.entities.JobAdvertisements;
import info.jobmela.entities.JobPostTypeMaster;
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
public class JobPostDto {

	private String jobPostId;
	private String jobPostHeading;
	private String jobPostName;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime jobPostLastUpdated;
	private int jobPostTotalVacancy;
	private String jobPostBriefInfo;
	private JobPostTypeMaster jobPostTypeMaster;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime jobPostCreationDate;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime jobPostLastUpdationDate;
	private String jobPostCreatedBy;
	private String jobPostUpdatedBy;
	private JobAdvertisements jobAdvertisements;
}
