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
	private Long userSeq;
	
	@Column(length = 500, columnDefinition = "TEXT")
	private String medicineName;
	
	@Column(nullable = false)
	private String medicineTimes;
	
	//content 같은 부분 추가해야함.
	@Column(nullable = false)
	private String content;
	
	@Builder
	public Medicines(Long user_seq, String medicine_name, String medicine_times) {
		this.userSeq = user_seq;
		this.medicineName = medicine_name;
		this.medicineTimes = medicine_times;
	}
	
	public void update(String medicine_name, String medicine_times, String content) {
		this.medicineName = medicine_name;
		this.medicineTimes = medicine_times;
		this.content = content;
	}
}
