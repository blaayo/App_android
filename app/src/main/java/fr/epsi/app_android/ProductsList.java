package fr.epsi.app_android;

import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProductsList extends ProjectActivity {

    ArrayList<Product> productsList;
    ProductAdapter productAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);

        String categoryTitle = getIntent().getExtras().getString("categoryTitle","");
        String products_url = getIntent().getExtras().getString("products_url", "");

        setTitle(categoryTitle);
        showBack();

        recyclerView = findViewById(R.id.productsList);

        productsList = new ArrayList<Product>();
        productAdapter = new ProductAdapter(this, productsList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(productAdapter);

        WebServiceCall wsCall= new WebServiceCall(products_url, new WebServiceCall.Callback() {
            @Override
            public void onComplete(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    JSONArray jsonItems = jsonObject.getJSONArray("items");
                    for (int i = 0; i < jsonItems.length(); i++){
                        Product product = null;
                        product = new Product(jsonItems.getJSONObject(i));
                        productsList.add(product);
                    }
                    productAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(fr.epsi.app_android.ProductsList.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        wsCall.run();

    }
}