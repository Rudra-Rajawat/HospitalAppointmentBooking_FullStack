package com.example.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.dto.DepartmentDTO;

@FeignClient("DEPARTMENT-SERVICE")
public interface DepartmentClient {
	
	@GetMapping("/departments/getAll")
    public ResponseEntity<List<DepartmentDTO>> getAll();
	
	@GetMapping("/departments/getById/{id}")
    public ResponseEntity<DepartmentDTO> getById(@PathVariable("id") Long id);
}
