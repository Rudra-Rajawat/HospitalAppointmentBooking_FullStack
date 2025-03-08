package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Enter a valid Patient name")
    @Size(min = 2, max = 50, message = "Patient name must be between 2 and 50 characters")
	private String name;
	
	@Min(value = 0, message = "Age must be greater than or equal to 0")
    @Max(value = 120, message = "Age must be less than or equal to 120")
	private Integer age;
	
	@NotBlank(message = "Enter a valid Patient Gender")
	@Pattern(regexp = "Male|Female", message = "Gender must be either 'Male' or 'Female'")
	private String gender;
}
