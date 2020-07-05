package com.mynutrient.service;
/**business Logic*/

import com.mynutrient.domain.user.Medicines;
import com.mynutrient.domain.user.MedicinesRepository;
import com.mynutrient.dto.MedicinesUpdateRequestDto;
import com.mynutrient.dto.UserRequestDto;

public class UserService {
	
	
	MedicinesRepository medicinesRepository;
	
	public long insert(Medicines entity) {
		
		return medicinesRepository.save(entity).getId();
	}

	public Long updateMyMedicines(Long id, MedicinesUpdateRequestDto updateRequestDto) {//파라미터에 dto추가해야함.
		// TODO Auto-generated method stub
		Medicines medicines = medicinesRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시물이 없습니다." ));
		//dto.getMedicien_name, dto.getMedicine_times
		medicines.update(updateRequestDto.getMedicineName(), updateRequestDto.getMedicineTimes(), updateRequestDto.getContent());
		return id;  
	}

	public void deleteMyMedicines(Long id) {
		Medicines medicines = medicinesRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다." + id));
		
		medicinesRepository.deleteById(id);
	}

	public UserRequestDto selectMyMedicines(Medicines medicines) {
		// TODO Auto-generated method stub
		return null;
	}

}
