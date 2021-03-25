package fr.epsi.app_android;

import org.json.JSONObject;

public class Product {

    private String name;
    private String description;
    private String picture_url;

    public Product(JSONObject obj) {
        name = obj.optString("name","");
        description = obj.optString("description", "");
        picture_url = obj.optString("picture_url", "");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture_url() {
        return this.picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

}
