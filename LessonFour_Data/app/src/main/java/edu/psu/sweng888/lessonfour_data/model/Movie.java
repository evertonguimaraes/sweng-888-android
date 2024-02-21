package edu.psu.sweng888.lessonfour_data.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

  public class Movie implements Parcelable {
    private int year;
    private float rating;
    private String description;
    private String title;
    private String category;

    public Movie(String title, String category, int year, float rating, String description) {
        this.title = title;
        this.category = category;
        this.year = year;
        this.rating = rating;
        this.description = description;
    }

    protected Movie(Parcel in) {
        title = in.readString();
        category = in.readString();
        year = in.readInt();
        rating = in.readFloat();
        description = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    /** Getters and Setters */
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(year);
        dest.writeFloat(rating);
        dest.writeString(description);
        dest.writeString(title);
        dest.writeString(category);
    }
}


