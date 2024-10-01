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
@Table(name = "job_fee_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class JobFeeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String jobFeeId;
	private int openFee;
	private int OBCFee;
	private int SCFee;
	private int STFee;
	@OneToOne(mappedBy = "jobFeeDetails")
	@JsonIgnore
	private JobAdvertisements jobAdvertisements;
}
