package com.example.frag;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

import data.Course;

public class CourseDetailActivity extends AppCompatActivity {
   Course course;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_course_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.detailContainer), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });
        if (savedInstanceState == null) {

            Bundle extra=getIntent().getExtras();
            assert extra != null;
            int position = extra.getInt("course_id");

            course=new CourseData().courseList().get(position);

            CourseDetailFragment fragment = new CourseDetailFragment();
            fragment.setArguments(extra);
            FragmentManager fragmentManager=getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .add(R.id.detailContainer,fragment)
                    .commit();

        }
    }
}