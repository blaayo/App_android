package fr.epsi.app_android;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<fr.epsi.app_android.CategoryAdapter.ViewHolder> {
    private ArrayList<Category> categoriesList;
    private ProjectActivity activity;

    public CategoryAdapter(ProjectActivity activity, ArrayList<Category> categories){
        this.activity = activity;
        this.categoriesList = categories;
    }

    @NonNull
    @Override
    public fr.epsi.app_android.CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.categories_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull fr.epsi.app_android.CategoryAdapter.ViewHolder holder, int position) {
        Category category = categoriesList.get(position);
        holder.getTextViewTitle().setText(category.getTitle());
        holder.getLayoutCell().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ProductsList.class);
                intent.putExtra("categoryTitle", category.getTitle());
                intent.putExtra("products_url", category.getProducts_url());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewTitle;
        private final View layoutCell;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            textViewTitle = view.findViewById(R.id.categoryTitle);
            layoutCell = view.findViewById(R.id.categoryItem);
        }

        public TextView getTextViewTitle() {
            return textViewTitle;
        }

        public View getLayoutCell() {
            return layoutCell;
        }

    }
}
