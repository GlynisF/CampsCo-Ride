package com.campuscoride.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 * The type Ride form.
 */
@Entity(name = "RideForm")
@Table(name = "ride_form")
public class RideForm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "request_type")
    private String requestType;

    @Column(name = "role_type")
    private String roleType;

    private LocalDate date;

    @Column (name = "notes")
    private String notes;

    @Column (name = "time")
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "student_id",
            foreignKey = @ForeignKey(name = "ride_form_student_id_fk")
    )
    @JsonBackReference
    private Student student;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    /**
     * Instantiates a new Ride form.
     */
    public RideForm() {

    }

    /**
     * Instantiates a new Ride form.
     *
     * @param roleType    the role type
     * @param requestType the request type
     * @param date        the date
     * @param time        the time
     * @param notes       the notes
     * @param student     the student
     */
    public RideForm(String roleType, String requestType, LocalDate date, LocalTime time, String notes, Student student, Location location) {
        this.requestType = requestType;
        this.roleType = roleType;
        this.date = date;
        this.time = time;
        this.notes = notes;
        this.student = student;
        this.location = location;
    }

    public RideForm(String roleType, String requestType, LocalDate date, LocalTime time, String notes, Student student) {
        this.requestType = requestType;
        this.roleType = roleType;
        this.date = date;
        this.time = time;
        this.notes = notes;
        this.student = student;
    }
    /**
     * Gets student.
     *
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Sets student.
     *
     * @param student the student
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * Gets notes.
     *
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets notes.
     *
     * @param notes the notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }


    /**
     * Gets date.
     *
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Gets role type.
     *
     * @return the role type
     */
    public String getRoleType() {
        return roleType;
    }

    /**
     * Sets role type.
     *
     * @param roleType the role type
     */
    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    /**
     * Gets request type.
     *
     * @return the request type
     */
    public String getRequestType() {
        return requestType;
    }

    /**
     * Sets request type.
     *
     * @param requestType the request type
     */
    public void setRequestType(String requestType) {
        this.requestType = requestType;
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
     * Gets time.
     *
     * @return the time
     */
    public LocalTime getTime() {
        return time;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RideForm rideForm = (RideForm) o;
        return id == rideForm.id && Objects.equals(requestType, rideForm.requestType) && Objects.equals(roleType, rideForm.roleType) && Objects.equals(date, rideForm.date) && Objects.equals(notes, rideForm.notes) && Objects.equals(time, rideForm.time) && Objects.equals(student, rideForm.student) && Objects.equals(location, rideForm.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, requestType, roleType, date, notes, time, student, location);
    }

    @Override
    public String toString() {
        return "RideForm{" +
                "id=" + id +
                ", requestType='" + requestType + '\'' +
                ", roleType='" + roleType + '\'' +
                ", date=" + date +
                ", notes='" + notes + '\'' +
                ", time=" + time +
                ", location=" + location +
                '}';
    }
}



