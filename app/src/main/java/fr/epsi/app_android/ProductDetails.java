package fr.epsi.app_android;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProductDetails extends fr.epsi.app_android.ProjectActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        String productName = getIntent().getExtras().getString("product_name","");
        String productDescription = getIntent().getExtras().getString("product_description", "");
        String productImage = getIntent().getExtras().getString("picture_url", "");

        TextView productDescriptionTextView = findViewById(R.id.productDescription);
        ImageView productImageImageView = findViewById(R.id.productImage);

        setTitle(productName);
        showBack();

        productDescriptionTextView.setText(productDescription);
        Picasso.get().load(productImage).into(productImageImageView);

    }
}