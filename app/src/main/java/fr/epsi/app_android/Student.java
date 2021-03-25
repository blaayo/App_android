package fr.epsi.app_android;

import org.json.JSONObject;

public class Student {

    private String name;
    private String email;
    private String url;
    private String group;

    public Student(JSONObject obj){
        name = obj.optString("name","");
        email = obj.optString("email","");
        url = obj.optString("picture_url","");
        group = obj.optString("group","");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

}
