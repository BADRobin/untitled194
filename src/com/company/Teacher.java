package com.company;

import java.util.List;

public class Teacher {
    private int id;
    private String fio;
    private int experience;

    private City city;

    private List<Course> courses;

    public Teacher() {
    }

    public Teacher(int id, String fio, int experience) {
        this.id = id;
        this.fio = fio;
        this.experience = experience;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
