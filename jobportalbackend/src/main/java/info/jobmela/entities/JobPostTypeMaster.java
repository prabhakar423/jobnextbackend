package info.jobmela.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "job_post_type_master")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JobPostTypeMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String jobPostTypeId;
	private String jobPostTypeName;
	private String jobPostTypeDesc;
}
