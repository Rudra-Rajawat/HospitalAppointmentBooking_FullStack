package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
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
