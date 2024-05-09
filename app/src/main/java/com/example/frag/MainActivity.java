package com.example.frag;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import data.Course;

public class MainActivity extends AppCompatActivity implements CourseListFragment.Callbacks{

    private boolean isTwoPane=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.myContainer), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (findViewById(R.id.detailContainer) != null) {
            isTwoPane=true;
        }
    }

    @Override
    public void onItemSelected(Course course,int position) {
      if(isTwoPane){
          Bundle bundle=new Bundle();
          bundle.putInt("course_id",position);

          FragmentManager fm=getSupportFragmentManager();
          CourseDetailFragment courseDetailFragment=new CourseDetailFragment();
           courseDetailFragment.setArguments(bundle);
          fm.beginTransaction()
                  .replace(R.id.detailContainer,courseDetailFragment)
                  .commit();
          return;
      }else {

          Intent intent = new Intent(this, CourseDetailActivity.class);
          intent.putExtra("course_id", position);
          startActivity(intent);
      }
    }
}