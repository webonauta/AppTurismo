package com.example.appturismo.models;

public class Place {

    private String title;
    private String description;
    private int thumnail;
    private String calificacion;
    private int coverPhoto;

    public Place(String title, int thumnail, int coverPhoto) {
        this.title = title;
        this.thumnail = thumnail;
        this.coverPhoto = coverPhoto;
    }

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

    public int getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(int coverPhoto) {
        this.coverPhoto = coverPhoto;
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
