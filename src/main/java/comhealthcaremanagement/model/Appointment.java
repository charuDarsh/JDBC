package comhealthcaremanagement.model;

public class Appointment {
   private int appointmentId;
    private int patientId;
    private int doctorId;
    private  String appointmentDate;
    private  String notes;

    public Appointment() {
    }

    public Appointment(int appointmentId, int patientId,int doctorId,String appointmentDate,
                       String notes) {
        this.appointmentDate = appointmentDate;
        this.appointmentId = appointmentId;
        this.doctorId = doctorId;
        this.notes = notes;
        this.patientId = patientId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
}
