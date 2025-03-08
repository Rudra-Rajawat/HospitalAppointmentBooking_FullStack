package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Department;
import com.example.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/register")
	public ResponseEntity<Department> registerDepartment(@RequestBody Department department){
		return new ResponseEntity<>(departmentService.registerDepartment(department),HttpStatus.CREATED);
	}
	
	@GetMapping("/getById/{id}")
    public ResponseEntity<Department> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(departmentService.getById(id),HttpStatus.OK);
    }
	
	@GetMapping("/getAll")
    public ResponseEntity<List<Department>> getAll(){
        return ResponseEntity.ok(departmentService.getAll());
    }
	
}
