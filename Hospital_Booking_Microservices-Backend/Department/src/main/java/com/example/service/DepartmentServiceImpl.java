package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Department;
import com.example.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public Department registerDepartment(Department department) {
		return departmentRepository.save(department);
	}
	
	@Override
	public Department getById(Long id) {
		return departmentRepository.findById(id).orElseThrow();
	}
	
	@Override
	public List<Department> getAll() {
		return departmentRepository.findAll();
	}

}
