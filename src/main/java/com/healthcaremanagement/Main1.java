package com.healthcaremanagement;

import com.healthcaremanagement.dao.DoctorDAO;
import com.healthcaremanagement.model.Doctor;

import java.sql.SQLException;
import java.util.List;

public class Main1 {
    public static void main(String[] args) throws SQLException {
        DoctorDAO doctorDAO = new DoctorDAO();
        // Create a new doctor
        Doctor doctor1 = new Doctor(4, "john.doe@example.com", "John", "Doe", "Cardiology");
        // doctorDAO.createDoctor(doctor1);

        // Retrieve a doctor by ID
        Doctor retrievedDoctor = doctorDAO.getDoctorById(2);
        // System.out.println("Retrieved Doctor: " + retrievedDoctor);

// Update the doctor's details
        Doctor retriveDoctor1 = doctorDAO.getDoctorById(1);
        //  retriveDoctor1.setFirstName("Daan");
        //  retriveDoctor1.setLastName("Smith");

        //  doctorDAO.updateDoctor(retriveDoctor1);
// Delete a doctor
        //   doctorDAO.deleteDoctor(4);

        List<Doctor> doctors = doctorDAO.getAllDoctors();
        for(Doctor dr:doctors ){
            System.out.println(dr);
        }
    }
}