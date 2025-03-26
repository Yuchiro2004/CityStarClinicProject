package com.CityStarClinic.Service;

import com.CityStarClinic.Entity.Doctor;
import com.CityStarClinic.Repository.AppointmentRepository;
import com.CityStarClinic.Repository.DoctorRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor registerDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
    
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Update doctor's availability
    public Doctor updateDoctorAvailability(Long id, Doctor doctor) {
        Optional<Doctor> existingDoctor = doctorRepository.findById(id);
        if (existingDoctor.isPresent()) {
            Doctor updatedDoctor = existingDoctor.get();
            updatedDoctor.setAvailability(doctor.getAvailability());
            return doctorRepository.save(updatedDoctor);
        }
        return null;
    }

    // Confirm an appointment for a doctor
    public void confirmAppointment(Long id) {
        AppointmentRepository.confirmAppointmentByDoctor(id);
    }
}

