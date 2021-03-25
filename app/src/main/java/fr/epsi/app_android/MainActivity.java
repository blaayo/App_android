package fr.epsi.app_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends fr.epsi.app_android.ProjectActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("EPSI");

        Button buttonZone1 = findViewById(R.id.buttonZone1);
        Button buttonZone2 = findViewById(R.id.buttonZone2);

        buttonZone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fr.epsi.app_android.MainActivity.this, GroupInfos.class);
                startActivity(intent);
            }
        });

        buttonZone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fr.epsi.app_android.MainActivity.this, fr.epsi.app_android.Categories.class);
                startActivity(intent);
            }
        });

    }
}