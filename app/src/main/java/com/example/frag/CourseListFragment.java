package com.example.frag;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import java.util.List;

import Util.ScreenUtility;
import data.Course;

public class CourseListFragment extends ListFragment {
    List<Course> courses=new CourseData().courseList();
    private Callbacks activity;
    public CourseListFragment(){
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScreenUtility screenUtility=new ScreenUtility(requireActivity());

        CourseArrayAdaptor adapter=new CourseArrayAdaptor(requireActivity(),R.layout.course_listitem,courses);
        setListAdapter(adapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.course_list_fragment,container,false);
    }
    public interface Callbacks{
        void onItemSelected(Course course,int position);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        Course course=courses.get(position);
        this.activity.onItemSelected(course,position);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.activity=(Callbacks)context;
    }
}
