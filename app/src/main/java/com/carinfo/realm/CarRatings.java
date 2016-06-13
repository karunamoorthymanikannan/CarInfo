package com.carinfo.realm;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by karunamoorthy on 9/6/16.
 */

public class CarRatings extends RealmObject {
    private Make make;
  private Model model;
    private Style style;
    private String summary;
    private String date;
    private String grade;
    private int id;
    private CarMakeYear year;
    private RealmList<Rattings> ratings;

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }


    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarMakeYear getYear() {
        return year;
    }

    public void setYear(CarMakeYear year) {
        this.year = year;
    }

   public RealmList<Rattings> getRatings() {
        return ratings;
    }

    public void setRatings(RealmList<Rattings> ratings) {
        this.ratings = ratings;
    }
}
