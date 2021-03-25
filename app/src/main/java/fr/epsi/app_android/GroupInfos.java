package fr.epsi.app_android;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GroupInfos extends fr.epsi.app_android.ProjectActivity {

    ArrayList<fr.epsi.app_android.Student> studentsList;
    fr.epsi.app_android.StudentAdapter studentAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_infos);

        setTitle("Infos");
        showBack();

        recyclerView = findViewById(R.id.studentsList);

        studentsList = new ArrayList<>();
        try {

            JSONObject jsonObject = new JSONObject(fr.epsi.app_android.GroupInfosData.studentsData);
            JSONArray jsonItems = jsonObject.getJSONArray("students");
            for (int i = 0; i < jsonItems.length(); i++){
                fr.epsi.app_android.Student student = new fr.epsi.app_android.Student(jsonItems.getJSONObject(i));
                studentsList.add(student);
            }

            studentAdapter = new fr.epsi.app_android.StudentAdapter(this,studentsList);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(studentAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}