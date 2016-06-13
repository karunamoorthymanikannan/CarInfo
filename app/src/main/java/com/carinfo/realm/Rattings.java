package com.carinfo.realm;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by karunamoorthy on 9/6/16.
 */

public class Rattings extends RealmObject {
    private String grade;
    private String summary;
    private String title;
    private float score;
    private RealmList<SubRattings> subRatings;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public RealmList<SubRattings> getSubRatings() {
        return subRatings;
    }

    public void setSubRatings(RealmList<SubRattings> subRatings) {
        this.subRatings = subRatings;
    }
}
