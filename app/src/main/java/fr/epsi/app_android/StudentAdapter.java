package fr.epsi.app_android;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<fr.epsi.app_android.StudentAdapter.ViewHolder>{

    private ArrayList<fr.epsi.app_android.Student> studentsList;
    private fr.epsi.app_android.ProjectActivity activity;

    public StudentAdapter(fr.epsi.app_android.ProjectActivity activity, ArrayList<fr.epsi.app_android.Student> students){
        this.activity = activity;
        this.studentsList = students;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.students_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        fr.epsi.app_android.Student student = studentsList.get(position);
        holder.getTextViewName().setText(student.getName());
        holder.getTextViewGroup().setText(student.getGroup());
        holder.getLayoutCell().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, fr.epsi.app_android.StudentInfo.class);
                intent.putExtra("studentName", student.getName());
                intent.putExtra("studentEmail", student.getEmail());
                intent.putExtra("studentGroup", student.getGroup());
                intent.putExtra("studentImageUrl", student.getUrl());
                activity.startActivity(intent);
            }
        });
//        holder.getTextViewEmail().setText(student.getEmail());
//        Picasso.get().load(student.getUrl()).into(holder.getImageViewStudent());
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewName;
        private final TextView textViewGroup;
        private final View layoutCell;
//        private final TextView textViewEmail;
//        private final ImageView imageViewStudent;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            textViewName = view.findViewById(R.id.studentName);
            textViewGroup = view.findViewById(R.id.studentGroup);
            layoutCell = view.findViewById(R.id.studentItem);
//            textViewEmail = view.findViewById(R.id.textViewEmail);
//            imageViewStudent =  view.findViewById(R.id.imageViewStudent);
        }

        public TextView getTextViewName() {
            return textViewName;
        }
        public TextView getTextViewGroup() {
            return textViewGroup;
        }
        public View getLayoutCell() {
            return layoutCell;
        }
//        public TextView getTextViewEmail() {
//            return textViewEmail;
//        }
//        public ImageView getImageViewStudent() {
//            return imageViewStudent;
//        }
    }

}
