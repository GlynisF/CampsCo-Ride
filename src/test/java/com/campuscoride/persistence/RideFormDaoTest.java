package com.campuscoride.persistence;

import com.campuscoride.entity.RideForm;
import com.campuscoride.entity.Student;
import com.campuscoride.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * The type Request form dao test.
 */
class RideFormDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The Student dao.
     */
    GenericDao<Student> studentDao;
    /**
     * The Ride form dao.
     */
    GenericDao<RideForm> rideFormDao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        studentDao = new GenericDao<>(Student.class);
        rideFormDao = new GenericDao<>(RideForm.class);
        Database db = Database.getInstance();
        db.runSQL("cleanDB.sql");
        logger.info(db.toString());
    }

    /**
     * Gets all ride forms.
     */
    void getAllRideForms() {
        List<RideForm> rideForms = rideFormDao.getAll();
        assertNotNull(rideForms);
        logger.info(rideForms);
    }

    /**
     * Gets ride form by id success.
     */
    @Test
    void getRideFormByIdSuccess() {
        RideForm rideForm = rideFormDao.getById(7);
        assertNotNull(rideForm);
        assertTrue(rideForm.getStudent().getId() == 2);

    }

    /**
     * Insert ride form success.
     */
    @Test
    void insertRideFormSuccess() {
        Student student = studentDao.getById(4);

        RideForm rideForm = new RideForm("Rider", "To Campus", LocalDate.parse("2024-12-15"),
                LocalTime.parse("04:00:00"), "Pickup near the square downtown.", student);

        student.addRideForm(rideForm);
        studentDao.update(student);

        RideForm insertedForm = rideFormDao.insert(rideForm);
        assertNotNull(insertedForm);

        logger.info(insertedForm);

    }

    /**
     * Update ride form success.
     */
    @Test
    void updateRideFormSuccess() {
        RideForm rideFormToUpdate = rideFormDao.getById(7);
        rideFormToUpdate.setRequestType("Updated Request Type");

        rideFormDao.update(rideFormToUpdate);
        assertNotNull(rideFormToUpdate);

        RideForm updatedRideForm = rideFormDao.getById(7);
        assertTrue(updatedRideForm.getRequestType().equals("Updated Request Type"));
    }

    /**
     * Delete ride form success.
     */
    @Test
    void deleteRideFormSuccess() {
        RideForm rideFormToDelete = rideFormDao.getById(6);
        rideFormDao.delete(rideFormToDelete);
        assertNotNull(rideFormToDelete);
    }
}