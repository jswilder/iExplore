package odomobileapplicationdevelopment.hikingapp;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by j on 9/25/17.
 */

public class Trail {
    @SerializedName("city")
    private String city;
    @SerializedName("state")
    private String state;
    @SerializedName("country")
    private String country;
    @SerializedName("name") private String name;
    @SerializedName("unique_id")
    private String unique_id;
    private String lat;
    private String lon;
    @SerializedName("url")
    private String url;
    @SerializedName("activities")
    private List<Activities> activities;

    @Override
    public String toString() {
        return "Trail{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", name='" + name + '\'' +
                ", unique_id='" + unique_id + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", url='" + url + '\'' +
                ", activities=" + activities +
                '}';
    }

    public Trail(){
        activities = new ArrayList<>();
    }

    public Trail(String city, String state, String country, String name, String unique_id, String lat, String lon, String url, List<Activities> activities) {
        this.city = city;
        this.state = state;
        this.country = country;
        this.name = name;
        this.unique_id = unique_id;
        this.lat = lat;
        this.lon = lon;
        this.url = url;
        this.activities = activities;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Activities> getActivities() {
        return activities;
    }

    public void setActivities(List<Activities> activities) {
        this.activities = activities;
    }
}
