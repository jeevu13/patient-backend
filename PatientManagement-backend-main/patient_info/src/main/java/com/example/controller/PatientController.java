package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.models.PatientModels;
import com.example.repository.PatientRepository;


@RestController
@RequestMapping("/patient")
@CrossOrigin
public class PatientController {
@Autowired

private PatientRepository patientRepository ;

@PostMapping("/add")
public String add(@RequestBody PatientModels patient)
{
patientRepository.save(patient) ;
return "New patient is added" ;
}
@GetMapping("/get")
public List<PatientModels> getAllStudent()
{
return patientRepository.findAll() ;
}
@GetMapping("/gets/{id}")
public PatientModels getAllStudents(@PathVariable int id)
{
	return patientRepository.findById(id).orElse(null) ;
}
@PutMapping("/put/{id}")
PatientModels update(@RequestBody PatientModels patient, @PathVariable int id)
{
	return patientRepository.findById(id)
			.map(patients->{
				patients.setName(patient.getName());
				patients.setAge(patient.getAge()) ;
				patients.setGender(patient.getGender());
				patients.setAddress(patient.getAddress());
				patients.setMobile(patient.getMobile());
				patients.setMartial(patient.getMartial());
				patients.setDate(patient.getDate());
				return patientRepository.save(patients) ;
			}).orElseThrow() ;
}
@DeleteMapping("/delete/{id}")
public String delete(@PathVariable int id)
{
patientRepository.deleteById(id) ;
return "Deleted Successfully" ;
}

}

