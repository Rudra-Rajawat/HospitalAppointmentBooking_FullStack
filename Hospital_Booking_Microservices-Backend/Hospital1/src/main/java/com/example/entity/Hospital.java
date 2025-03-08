package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Enter a valid Hospital name")
    @Size(min = 2, max = 50, message = "Hospital name must be between 2 and 50 characters")
	private String name;
	
	@NotBlank(message = "Enter a valid Hospital Address")
    @Size(min = 2, max = 50, message = "Hospital Address must be between 2 and 50 characters")
	private String address;
}
