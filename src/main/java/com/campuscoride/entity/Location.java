package com.campuscoride.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Entity (name = "Location")
@Table (name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;

    @Column (name = "location_name")
    private String locationName;

    private double lat;

    private double lng;

    @Column (name = "postal_code")
    private Integer zipcode;

    @OneToOne(mappedBy = "location")
    private RideForm rideForm;

    public Location() {
    }

    public Location(String locationName, double lat, double lng, Integer zipcode) {
        this.locationName = locationName;
        this.lat = lat;
        this.lng = lng;
        this.zipcode = zipcode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public RideForm getRideForm() {
        return rideForm;
    }

    public void setRideForm(RideForm rideForm) {
        this.rideForm = rideForm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return id == location.id && Double.compare(lat, location.lat) == 0 && Double.compare(lng, location.lng) == 0 && zipcode == location.zipcode && Objects.equals(locationName, location.locationName) && Objects.equals(rideForm, location.rideForm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, locationName, lat, lng, zipcode, rideForm);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", locationName='" + locationName + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", zipcode=" + zipcode +
                '}';
    }
}
