package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Patient;

/**
 * PatientRepository is a repository interface for managing Patient entities.
 * It extends JpaRepository to provide CRUD operations for Patient entities.
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}