package com.example.assignment1;

public class Model {
    private String title;
    private String description;

    // Constructor to initialize title and description
    public Model(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }
}
