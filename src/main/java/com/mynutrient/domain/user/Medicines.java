package com.mynutrient.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**직접적으로 DB와 관련있는 부분*/
@Getter
@NoArgsConstructor
@Entity
public class Medicines {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Long user_seq;
	
	@Column(length = 500, columnDefinition = "TEXT")
	private String medicine_name;
	
	private String medicine_times;

	
	@Builder
	public Medicines(Long user_seq, String medicine_name, String medicine_times) {
		this.user_seq = user_seq;
		this.medicine_name = medicine_name;
		this.medicine_times = medicine_times;
	}
	
}
