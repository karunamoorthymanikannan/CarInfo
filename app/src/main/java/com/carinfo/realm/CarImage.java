package com.carinfo.realm;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by karunamoorthy on 8/6/16.
 */

public class CarImage extends RealmObject {

    private String makeName;
    private String modelName;
    private String styleId;
    public String captionTranscript;
    public String id;
    public String shotTypeAbbreviation;
    public String site;
    public String source;
    public String subType;
    public String type;

    public String getCaptionTranscript() {
        return captionTranscript;
    }

    public void setCaptionTranscript(String captionTranscript) {
        this.captionTranscript = captionTranscript;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShotTypeAbbreviation() {
        return shotTypeAbbreviation;
    }

    public void setShotTypeAbbreviation(String shotTypeAbbreviation) {
        this.shotTypeAbbreviation = shotTypeAbbreviation;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RealmList<CustomString> getPhotoSrcs() {
        return photoSrcs;
    }

    public void setPhotoSrcs(RealmList<CustomString> photoSrcs) {
        this.photoSrcs = photoSrcs;
    }

    public RealmList<CustomString> getAuthorNames() {
        return authorNames;
    }

    public void setAuthorNames(RealmList<CustomString> authorNames) {
        this.authorNames = authorNames;
    }

    private int year;
    private RealmList<CustomString> photoSrcs;
    private RealmList<CustomString> authorNames;

    public String getMakeName() {
        return makeName;
    }

    public void setMakeName(String makeName) {
        this.makeName = makeName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getStyleId() {
        return styleId;
    }

    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
