package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.PatientModels;

public interface PatientRepository extends JpaRepository<PatientModels,Integer>{

}
