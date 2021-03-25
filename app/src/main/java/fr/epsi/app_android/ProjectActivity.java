package fr.epsi.app_android;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProjectActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("tag","############## onCreate ################# :"+getClass().getSimpleName());
    }

    public void setTitle(String title){
        TextView headerTiltle =findViewById(R.id.header_title);
        if(headerTiltle != null)
            headerTiltle.setText(title);
    }

    public void showBack(){
        ImageView imageView = findViewById(R.id.header_image_view_back);
        if(imageView != null){
            imageView.setVisibility(View.VISIBLE);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
    }

    @Override
    public void finish() {
        super.finish();
        Log.d("tag","############## finish ################# :"+getClass().getSimpleName());
    }
}
