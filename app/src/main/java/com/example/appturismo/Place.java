package com.example.appturismo;

public class Place {

    private String title;
    private String description;
    private int thumnail;
    private String calificacion;

    public Place(String title, int thumnail) {
        this.title = title;
        this.thumnail = thumnail;
    }

    public Place(String title, String description, int thumnail, String calificacion) {
        this.title = title;
        this.description = description;
        this.thumnail = thumnail;
        this.calificacion = calificacion;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getThumnail() {
        return thumnail;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setThumnail(int thumnail) {
        this.thumnail = thumnail;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }
}
