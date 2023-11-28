package com.example.soustenir.ui.company;

import com.google.firebase.firestore.GeoPoint;

public class Company {
    private String name;
    private String description;
    private GeoPoint location; // Firestore GeoPoint
    private double score;
    private String url;

    public Company() {
        // Default constructor required for calls to DataSnapshot.getValue(Company.class)
    }

    public Company(String name, String description, GeoPoint location, double score, String url) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.score = score;
        this.url = url;
    }

    // Getters and setters
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }
    public String getUrl() {
        return url;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GeoPoint getLocation() {
        return location;
    }

    public void setLocation(GeoPoint location) {
        this.location = location;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}