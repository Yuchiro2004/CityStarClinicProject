package com.CityStarClinic.Controller;

import com.CityStarClinic.Entity.Doctor;
import com.CityStarClinic.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // Register a doctor
    @PostMapping("/register")
    public Doctor registerDoctor(@RequestBody Doctor doctor) {
        return doctorService.registerDoctor(doctor);
    }

    // Get all doctors
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    // Update doctor availability
    @PutMapping("/availability/{id}")
    public Doctor updateDoctorAvailability(@PathVariable Long id, @RequestBody Doctor doctor) {
        return doctorService.updateDoctorAvailability(id, doctor);
    }

    // Confirm an appointment for a doctor
    @PutMapping("/confirm-appointment/{id}")
    public String confirmAppointment(@PathVariable Long id) {
        doctorService.confirmAppointment(id);
        return "Appointment confirmed";
    }
}
