package com.mynutrient.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mynutrient.demo.dto.PostsUpdateRequestDto;
import com.mynutrient.domain.user.Medicines;
import com.mynutrient.dto.MedicinesUpdateRequestDto;
import com.mynutrient.dto.UserRequestDto;
import com.mynutrient.service.UserService;

import lombok.RequiredArgsConstructor;

/**URL...*/
@RequiredArgsConstructor
@RestController
public class UserApiController {

	private final UserService userService;
  	
	@PostMapping("/user/medicines/add/{id}")
	public Long insertMyMedicines(@RequestBody Medicines medicines) {
		return userService.insert(medicines);
	}
			
	@PutMapping("/user/medicines/modify/{id]")
	public Long updateMyMedicines(@PathVariable Long id, @RequestBody MedicinesUpdateRequestDto updateRequestDto) {
		return userService.updateMyMedicines(id, updateRequestDto);
	}
	
	@DeleteMapping("/user/medicines/delete/{id}")
	public long deleteMyMedicines(@PathVariable Long id) {
		userService.deleteMyMedicines(id);
		return id;
	}
	
	@GetMapping("/user/medicines/select/{id}")
	public UserRequestDto selectMyMedicines(@RequestBody Medicines medicines) {
		return userService.selectMyMedicines(medicines);
	}
	
	
}
