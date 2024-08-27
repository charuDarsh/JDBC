package com.healthcaremanagement.dao;

import com.healthcaremanagement.model.Doctor;
import healthcare.jdbc.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
   public void createDoctor(Doctor doctor) throws SQLException {
       String query = "Insert into Doctors(DoctorID,firstName,lastName,specialty,email) values (?,?, ?, ?, ?)";
       try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
           stmt.setInt(1, doctor.getDoctorId());
           stmt.setString(2, doctor.getFirstName());
           stmt.setString(3, doctor.getLastName());
           stmt.setString(4, doctor.getSpecialty());
           stmt.setString(5, doctor.getEmail());
           stmt.executeUpdate();
       }
   }

    public Doctor getDoctorById(int doctorId) throws SQLException {
        String query = "Select * from Doctors where DoctorId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, doctorId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Doctor doctor = new Doctor(
                            rs.getInt("DoctorID"),
                            rs.getString("FirstName"),
                            rs.getString("LastName"),
                            rs.getString("Specialty"),
                            rs.getString("Email")
                    );
                    return doctor;

                }
            }
        }
        return null;
    }
     public void  updateDoctor(Doctor doctor) throws SQLException {
         String query = "Update Doctors Set  FirstName = ?,LastName = ?,Specialty =?,Email =? where DoctorID = ?";
         try(Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)
         ){
      stmt.setString(1,doctor.getFirstName());
      stmt.setString(2,doctor.getLastName());
      stmt.setString(3, doctor.getSpecialty());
      stmt.setString(4,doctor.getEmail());
      stmt.setInt(5,doctor.getDoctorId());
      stmt.executeUpdate();
         }
        }
     public void deleteDoctor(int doctorId) throws SQLException{
       String query ="Delete from Doctors where DoctorID  = ?";
       try(Connection conn = DatabaseConnection.getConnection();
       PreparedStatement stmt = conn.prepareStatement(query)){
         stmt.setInt(1,doctorId);
         stmt.executeUpdate();
       }
     }
     public List<Doctor> getAllDoctors() throws SQLException {
       String query = "Select * from Doctors";
       List<Doctor> doctors = new ArrayList<>();
       try(Connection conn = DatabaseConnection.getConnection();
       PreparedStatement  stmt = conn.prepareStatement(query)){
          ResultSet rs = stmt.executeQuery();
          while(rs.next()){
              Doctor doctor = new Doctor(
                      rs.getInt("DoctorID"),
                      rs.getString("FirstName"),
                      rs.getString("LastName"),
                      rs.getString("Specialty"),
                      rs.getString("Email")
              );
              doctors.add(doctor);
          }
       }
         return doctors;
     }


   }

