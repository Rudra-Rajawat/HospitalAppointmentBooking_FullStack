package com.example.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
	
	private Long id;
	private Long userId;
	private Long patientId;
	private String patientName;
	private int patientAge;
	private String patientGender;
	private Long hospitalId;
	private String hospitalName;
	private String hospitalAddress;
	private Long departmentId;
	private String departmentName;
	
	@NotBlank(message = "Status cannot be empty")
	private String status;
}
