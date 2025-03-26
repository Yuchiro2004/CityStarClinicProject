package com.CityStarClinic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CityStarClinic.Entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}



