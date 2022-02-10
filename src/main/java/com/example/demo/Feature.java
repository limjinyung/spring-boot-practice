package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Feature {

    private String featureName;
    @Id
    private String email;
    private Boolean enable;

    public String getFeatureName() {
        return featureName;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Feature() {
    }

    public Feature(String featureName, String email, boolean enable){
        super();
        this.featureName = featureName;
        this.email = email;
        this.enable = enable;
    }
}