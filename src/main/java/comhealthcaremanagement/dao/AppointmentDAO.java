package comhealthcaremanagement.dao;

import com.healthcaremanagement.model.Doctor;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import comhealthcaremanagement.model.Appointment;
import healthcare.jdbc.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {
    // Inserts a new appointment into the `Appointments
    public void createAppointment(Appointment appointment) throws SQLException {
        String sqlQuery = "INSERT INTO Appointments(PatientID,DoctorID,AppointmentDate,Notes) Values (?,?,?,?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setInt(1, appointment.getPatientId());
            stmt.setInt(2, appointment.getDoctorId());
            stmt.setString(3, appointment.getAppointmentDate());
            stmt.setString(4, appointment.getNotes());
            stmt.executeUpdate();


        }

    }

    // Retrieves an appointment from the database based on the given ID
    public Appointment getAppointmentById(int appointmentId) throws SQLException {
        String sqlQuery = "Select * from Appointments where appointmentId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setInt(1, appointmentId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Appointment appointment = new Appointment(
                            rs.getInt("appointmentId"),
                            rs.getInt("patientId"),
                            rs.getInt("doctorId"),
                            rs.getString("appointmentDate"),
                            rs.getString("notes")
                    );
                    return appointment;

                }
            }
        }
        return null;
    }

    // updates existing appointment details in the `Appointments` table using an `UPDATE` statement.
    public void updateAppointment(Appointment appointment) throws SQLException {
        String sqlQuery = "Update Appointments SET PatientID =?,DoctorID=?,AppointmentDate=?,Notes=? where AppointmentID = ? ";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlQuery)
        ) {
            stmt.setInt(1, appointment.getAppointmentId());
            stmt.setInt(3, appointment.getPatientId());
            stmt.setInt(2, appointment.getDoctorId());
            stmt.setString(4, appointment.getAppointmentDate());
            stmt.setString(5, appointment.getNotes());
            stmt.executeUpdate();
        }
    }

    public void deleteAppointment(int appointmentId) throws SQLException {
        String sqlQuery = "Delete from Appointments where AppointmentID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setInt(1, appointmentId);
            stmt.executeUpdate();
        }
    }

    public List<Appointment> getAllAppointments() throws SQLException {
        String sqlQuery = "Select * from Appointments";
        List<Appointment> appointments = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            ResultSet st = stmt.executeQuery();
            while (st.next()) {
                Appointment appointment = new Appointment(st.getInt("AppointmentId"),
                        st.getInt("PatientID"),
                        st.getInt("DoctorID"),
                        st.getString("AppointmentDate"),
                        st.getString(" Notes"));
                appointments.add(appointment);
            }
        }
        return appointments;
    }
}





