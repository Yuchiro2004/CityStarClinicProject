package com.CityStarClinic.Repository;

import com.CityStarClinic.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctorId(Long doctorId); // Find appointments by doctor ID
    static List<Appointment> findByPatientId(Long patientId) {
		// TODO Auto-generated method stub
		return null;
	} // Find appointments by patient ID
    static void confirmAppointmentByDoctor(Long id) {
		// TODO Auto-generated method stub
		
	} // Method for confirming appointment by doctor (could be customized if needed)
}