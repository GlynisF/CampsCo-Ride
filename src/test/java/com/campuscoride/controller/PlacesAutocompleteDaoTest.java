package com.campuscoride.controller;

import com.googleapis.maps.places.AddressComponentsItem;
import com.googleapis.maps.places.AutocompletePredictions;
import com.googleapis.maps.places.PlaceDetailsResults;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Places autocomplete dao test.
 */
class PlacesAutocompleteDaoTest {

    private final Logger logger;
    private PlacesAutocompleteDao autocompleteDao;

    PlacesAutocompleteDaoTest() {
        logger = LogManager.getLogger(this.getClass());
    }

    /**
     * Sets up pre-test tasks for PlacesAutocompleteDao.
     */
    @BeforeEach
    void setUp() {
        autocompleteDao = new PlacesAutocompleteDao();
    }

    /**
     * Gets places autocomplete response success.
     *
     * @throws IOException the io exception
     */
    @Test
    void getPlacesAutocompleteResponseSuccess() throws IOException {
        AutocompletePredictions predictions = autocompleteDao.autocompleteResponse("Madison");
        assertNotNull(predictions);
        assertTrue("Madison, WI, USA".equals(predictions.getPredictions().get(0).getDescription()));


        AutocompletePredictions predictions2 = autocompleteDao.autocompleteResponse("Tampa");
        assertNotNull(predictions2);
        assertTrue("Tampa, FL, USA".equals(predictions2.getPredictions().get(0).getDescription()));
    }

    /**
     * Gets places autocomplete place id success.
     *
     * @throws IOException the io exception
     */
    @Test
    void getPlacesAutocompletePlaceIdSuccess() throws IOException {
        AutocompletePredictions predictions = autocompleteDao.autocompleteResponse("Madison");
        assertNotNull(predictions);
        assertEquals("ChIJ_xkgOm1TBogRmEFIurX8DE4", predictions.getPredictions().get(0).getPlaceId());

        AutocompletePredictions predictions2 = autocompleteDao.autocompleteResponse("Tampa");
        assertNotNull(predictions2);
        assertEquals("ChIJ4dG5s4K3wogRY7SWr4kTX6c", predictions2.getPredictions().get(0).getPlaceId());

    }

    /**
     * Gets place details from place id success.
     *
     * @throws IOException the io exception
     */
    @Test
    void getPlaceDetailsFromPlaceIdSuccess() throws IOException {
        // Testing results for 'Madison'
        AutocompletePredictions predictions = autocompleteDao.autocompleteResponse("Madison");
        assertNotNull(predictions);

        String placeId = predictions.getPredictions().get(0).getPlaceId();
        PlaceDetailsResults results = autocompleteDao.placeDetailsResponse(placeId);
        assertNotNull(results);

        Object madisonLng = results.getResult().getGeometry().getLocation().getLng();
        Object madisonLat = results.getResult().getGeometry().getLocation().getLat();

        assertEquals(Double.parseDouble("-89.4007501"), madisonLng);
        assertEquals(Double.parseDouble("43.0721661"), madisonLat);

        // Testing results for 'Tampa'
        AutocompletePredictions predictions2 = autocompleteDao.autocompleteResponse("Tampa");
        assertNotNull(predictions2);

        String placeId2 = predictions2.getPredictions().get(0).getPlaceId();
        PlaceDetailsResults results2 = autocompleteDao.placeDetailsResponse(placeId2);
        assertNotNull(results2);

        Object tampaLng = results2.getResult().getGeometry().getLocation().getLng();
        Object tampaLat = results2.getResult().getGeometry().getLocation().getLat();

        assertEquals(Double.parseDouble("-82.45875269999999"), tampaLng);
        assertEquals(Double.parseDouble("27.9516896"), tampaLat);
    }

    /**
     * Location within radius success.
     *
     * @throws IOException the io exception
     */
    @Test
    void locationWithinRadiusSuccess() throws IOException {
        // Get Place Details for Madison by placeId
        PlaceDetailsResults results = autocompleteDao.placeDetailsResponse("ChIJ_xkgOm1TBogRmEFIurX8DE4");
        assertNotNull(results);

        // Get PLace Details for Tampa by placeId
        PlaceDetailsResults results2 = autocompleteDao.placeDetailsResponse("ChIJ26DlHEJGBogRSyoYMtBjNKQ");
        assertNotNull(results2);

        Double madisonLng = (Double) results.getResult().getGeometry().getLocation().getLng();
        double madLng = Double.parseDouble(String.format("%.2f", (Double) results.getResult().getGeometry().getLocation().getLng()));

        Double madisonLat = (Double) results.getResult().getGeometry().getLocation().getLat();
        double madLat = Double.parseDouble(String.format("%.2f", madisonLat));

        for (AddressComponentsItem item : autocompleteDao.placeDetailsResponse("ChIJ_xkgOm1TBogRmEFIurX8DE4").getResult().getAddressComponents() ) {
            logger.info(item.toString());
        }
        Double stoughtonLng = (Double) results2.getResult().getGeometry().getLocation().getLng();
        double stoughLng = Double.parseDouble(String.format("%.2f", stoughtonLng));

        Double stoughtonLat = (Double) results2.getResult().getGeometry().getLocation().getLat();
        double stoughLat = Double.parseDouble(String.format("%.2f", stoughtonLat));


        double radiusResults = PlacesAutocompleteDao.haversine(madLat, madLng, stoughLat, stoughLng);

        assertTrue(radiusResults <= 25);

        logger.info(Math.round(radiusResults));


    }
}