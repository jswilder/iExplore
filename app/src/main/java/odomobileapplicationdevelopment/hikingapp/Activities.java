package odomobileapplicationdevelopment.hikingapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by j on 9/25/17.
 */

public class Activities {
    @SerializedName("name")
    private String name;
    @SerializedName("unique_id")
    private String unique_id;
    @SerializedName("place_id")
    private String place_id;
    private String activity_type_id;
    @SerializedName("activity_type_name")
    private String activity_type_name;
    private String url;
    private String description;
    private String thumbnail;
    private String length;
    @SerializedName("rating")
    private String rating;

    public Activities(String name, String unique_id, String place_id, String activity_type_id, String activity_type_name, String url, String description, String thumbnail, String length, String rating) {
        this.name = name;
        this.unique_id = unique_id;
        this.place_id = place_id;
        this.activity_type_id = activity_type_id;
        this.activity_type_name = activity_type_name;
        this.url = url;
        this.description = description;
        this.thumbnail = thumbnail;
        this.length = length;
        this.rating = rating;
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

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public String getActivity_type_id() {
        return activity_type_id;
    }

    public void setActivity_type_id(String activity_type_id) {
        this.activity_type_id = activity_type_id;
    }

    public String getActivity_type_name() {
        return activity_type_name;
    }

    public void setActivity_type_name(String activity_type_name) {
        this.activity_type_name = activity_type_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Activities{" +
                "name='" + name + '\'' +
                ", unique_id='" + unique_id + '\'' +
                ", place_id='" + place_id + '\'' +
                ", activity_type_id='" + activity_type_id + '\'' +
                ", activity_type_name='" + activity_type_name + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", length='" + length + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
