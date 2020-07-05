package com.mynutrient.dto;

import javax.persistence.Column;

import com.mynutrient.domain.user.Medicines;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**queries :  view Layer...*/
@Getter
@NoArgsConstructor
public class MedicinesUpdateRequestDto {//request,resonse용으로도 분리함....
	
//	private Long id; // user column의 pk
	
	private Long id;
	private String medicineName;
	private String medicineTimes;
	private String content;
	
	
	
	@Builder
	public MedicinesUpdateRequestDto(long postId, String medicine_name, String medicine_time) {
		this.id = postId;//medicines.getUser_seq();
		this.medicineName = medicine_name; //medicines.getMedicine_name();
		this.medicineTimes = medicine_time;//emedicines.getMedicine_times();
	}

	public Medicines toEntity() {
		return Medicines.builder()
				.medicine_name(medicineName)
				.medicine_times(medicineTimes)
				.build();
	}

}
