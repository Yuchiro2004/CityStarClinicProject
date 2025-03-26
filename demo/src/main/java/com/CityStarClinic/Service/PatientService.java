package com.CityStarClinic.Service;

import com.CityStarClinic.Entity.Appointment;
import com.CityStarClinic.Entity.Patient;
import com.CityStarClinic.Repository.PatientRepository;
import com.CityStarClinic.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository; // Injected instance

    @Autowired
    public PatientService(PatientRepository patientRepository, AppointmentRepository appointmentRepository) {
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public Patient registerPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Get patient's appointment history
    public List<Appointment> getPatientAppointments(Long patientId) {
        return AppointmentRepository.findByPatientId(patientId); // Use the injected instance
    }

    // Create an appointment
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment); // Use the injected instance
    }
}
