package fr.epsi.app_android;

import org.json.JSONObject;

public class Category {

    private String category_id;
    private String title;
    private String products_url;

    public Category(JSONObject obj) {
        category_id = obj.optString("category_id", "");
        title = obj.optString("title", "");
        products_url = obj.optString("products_url", "");
    }

    public String getCategory_id() {
        return this.category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProducts_url() {
        return this.products_url;
    }

    public void setProducts_url(String products_url) {
        this.products_url = products_url;
    }
}
