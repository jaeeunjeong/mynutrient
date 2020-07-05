package com.mynutrient.dto;

import javax.persistence.Column;

import com.mynutrient.domain.user.Medicines;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**queries :  view Layer...*/
@Getter
@NoArgsConstructor
public class UserRequestDto {//request,resonse용으로도 분리함....
	
//	private Long id; // user column의 pk
	
	private Long userSeq;
	private String medicineName;
	private String medicineTimes;
	
	
	
	@Builder
	public UserRequestDto(long user_seq, String medicine_name, String medicine_time) {
		this.userSeq = user_seq;//medicines.getUser_seq();
		this.medicineName = medicine_name; //medicines.getMedicine_name();
		this.medicineTimes = medicine_time;//emedicines.getMedicine_times();
	}

	public Medicines toEntity() {
		return Medicines.builder()
				.user_seq(userSeq)
				.medicine_name(medicineName)
				.medicine_times(medicineTimes)
				.build();
	}

}
