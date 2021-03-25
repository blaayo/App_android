package fr.epsi.app_android;

import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Categories extends fr.epsi.app_android.ProjectActivity {
    ArrayList<fr.epsi.app_android.Category> categoriesList;
    fr.epsi.app_android.CategoryAdapter categoryAdapter;
    RecyclerView recyclerView;
    String categories_url = "https://djemam.com/epsi/categories.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        setTitle("Rayons");
        showBack();

        recyclerView = findViewById(R.id.categoriesList);

        categoriesList = new ArrayList<fr.epsi.app_android.Category>();
        categoryAdapter = new fr.epsi.app_android.CategoryAdapter(this, categoriesList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(categoryAdapter);

        WebServiceCall wsCall= new WebServiceCall(categories_url, new WebServiceCall.Callback() {
            @Override
            public void onComplete(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    JSONArray jsonItems = jsonObject.getJSONArray("items");
                    for (int i = 0; i < jsonItems.length(); i++){
                        fr.epsi.app_android.Category category = null;
                        category = new fr.epsi.app_android.Category(jsonItems.getJSONObject(i));
                        categoriesList.add(category);
                    }
                    categoryAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(fr.epsi.app_android.Categories.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        wsCall.run();
    }
}