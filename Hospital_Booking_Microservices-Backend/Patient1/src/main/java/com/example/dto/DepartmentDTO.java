package com.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DepartmentDTO {
//	private Long id;
//	private String name;
	
	private Long id;
	
	@NotBlank(message = "Enter a valid Department name")
    @Size(min = 2, max = 50, message = "Department name must be between 2 and 50 characters")
	private String name;
}
