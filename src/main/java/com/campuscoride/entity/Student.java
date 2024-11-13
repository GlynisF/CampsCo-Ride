package com.campuscoride.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Student.
 */
@Entity (name = "CampusCoRide")
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "student_id")
    private int studentId;

    @Column (name = "email")
    private String email;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<RideForm> rideForms = new ArrayList<>();

    /**
     * Instantiates a new Student.
     */
    public Student() {

    }

    /**
     * Instantiates a new Student.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param email     the email
     * @param studentId the student id
     */
    public Student(String firstName, String lastName, String email, int studentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.email = email;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets student id.
     *
     * @return the student id
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * Sets student id.
     *
     * @param studentId the student id
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets ride forms.
     *
     * @return the ride forms
     */
    public List<RideForm> getRideForms() {
        return rideForms;
    }

    /**
     * Sets ride forms.
     *
     * @param rideForms the ride forms
     */
    public void setRideForms(List<RideForm> rideForms) {
        this.rideForms = rideForms;
    }

    /**
     * Add ride form.
     *
     * @param rideForm the ride form
     */
    public void addRideForm(RideForm rideForm) {
        rideForms.add(rideForm);
        rideForm.setStudent(this);
    }

    /**
     * Remove ride form.
     *
     * @param rideForm the ride form
     */
    public void removeRideForm(RideForm rideForm) {
        rideForms.remove(rideForm);
        rideForm.setStudent(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && studentId == student.studentId && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(email, student.email) && Objects.equals(rideForms, student.rideForms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, studentId, email, rideForms);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentId=" + studentId +
                ", email='" + email + '\'' +
                '}';
    }

}
