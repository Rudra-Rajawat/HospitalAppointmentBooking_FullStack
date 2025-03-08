package com.example.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.entity.Department;

@Service
public interface DepartmentService {
	Department registerDepartment(Department department);
	Department getById(Long id);
	List<Department> getAll();
}
