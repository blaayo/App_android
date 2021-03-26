package fr.epsi.app_android;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<fr.epsi.app_android.ProductAdapter.ViewHolder> {

    private ArrayList<fr.epsi.app_android.Product> productsList;
    private fr.epsi.app_android.ProjectActivity activity;

    public ProductAdapter(fr.epsi.app_android.ProjectActivity activity, ArrayList<fr.epsi.app_android.Product> products){
        this.activity = activity;
        this.productsList = products;
    }

    @NonNull
    @Override
    public fr.epsi.app_android.ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.products_list_item, viewGroup, false);
        return new fr.epsi.app_android.ProductAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull fr.epsi.app_android.ProductAdapter.ViewHolder holder, int position) {
        fr.epsi.app_android.Product product = productsList.get(position);
        holder.getTextViewName().setText(product.getName());
        holder.getTextViewDescription().setText(product.getDescription());
        Picasso.get().load(product.getPicture_url()).into(holder.getImageViewProductImage());

        holder.getLayoutCell().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, fr.epsi.app_android.ProductDetails.class);
                intent.putExtra("product_name", product.getName());
                intent.putExtra("product_description", product.getDescription());
                intent.putExtra("picture_url", product.getPicture_url());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewName;
        private final TextView textViewDescription;
        private final ImageView imageViewProductImage;
        private final View layoutCell;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            textViewName = view.findViewById(R.id.productName);
            textViewDescription = view.findViewById(R.id.productDescription);
            imageViewProductImage = view.findViewById(R.id.productImage);
            layoutCell = view.findViewById(R.id.categoryItem);
        }

        public TextView getTextViewName() {
            return textViewName;
        }

        public TextView getTextViewDescription() {
            return textViewDescription;
        }

        public ImageView getImageViewProductImage() {
            return imageViewProductImage;
        }

        public View getLayoutCell() {
            return layoutCell;
        }

    }

}
