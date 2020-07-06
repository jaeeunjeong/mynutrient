package com.mynutrient.service;
/**business Logic*/

import javax.transaction.Transactional;

import com.mynutrient.domain.user.Medicines;
import com.mynutrient.domain.user.MedicinesRepository;
import com.mynutrient.dto.MedicinesUpdateRequestDto;
import com.mynutrient.dto.UserRequestDto;

public class UserService {
	
	
	MedicinesRepository medicinesRepository;
	
	@Transactional
	public long insert(Medicines entity) {
		return medicinesRepository.save(entity).getId();
	}
	@Transactional
	public Long updateMyMedicines(Long id, MedicinesUpdateRequestDto updateRequestDto) {
		// TODO Auto-generated method stub
		Medicines medicines = medicinesRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시물이 없습니다." ));
		medicines.update(updateRequestDto.getMedicineName(), updateRequestDto.getMedicineTimes(), updateRequestDto.getContent());
		return id;  
	}
	
	@Transactional	
	public void deleteMyMedicines(Long id) {
		Medicines medicines = medicinesRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다." + id));
		
		medicinesRepository.deleteById(id);
	}
	//get
	public UserRequestDto selectMyMedicines(Medicines medicines) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void findById(Long id) {
		
	}

}
