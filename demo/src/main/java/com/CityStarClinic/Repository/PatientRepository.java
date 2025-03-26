package com.CityStarClinic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CityStarClinic.Entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
