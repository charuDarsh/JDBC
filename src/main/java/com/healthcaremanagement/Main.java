package com.healthcaremanagement;

import com.healthcaremanagement.dao.DoctorDAO;
import com.healthcaremanagement.model.Doctor;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        DoctorDAO doctorDAO = new DoctorDAO();
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Create Doctor");
        System.out.println("2. Read Doctor");
        System.out.println("3. Update Doctor");
        System.out.println("4. Delete Doctor");
        int choice = sc.nextInt();
        sc.nextLine();
        try {
            switch (choice) {
                case 1:
                // Create Doctor
                Doctor doctor1 = new Doctor();
                    System.out.print("Enter first name: ");
                    doctor1.setFirstName(sc.nextLine());
                    System.out.print("Enter last name: ");
                    doctor1.setLastName(sc.nextLine());
                    System.out.print("Enter specialty: ");
                    doctor1.setSpecialty(sc.nextLine());
                    System.out.print("Enter : Email");
                    doctor1.setEmail(sc.nextLine());
                    doctorDAO.createDoctor(doctor1);
                    System.out.println("Doctor created successfully.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            sc.close();
        }
            }
        }



