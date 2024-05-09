package com.example.frag;

import java.util.ArrayList;

import data.Course;

public class CourseData {
    private String[] courseNames = {"First Course","Second Course","Third Course","Fourth Course","Fifth Course","Sixth Course","Seventh Course"};

    public ArrayList<Course> courseList(){
        ArrayList<Course> list = new ArrayList<>();
        for (String courseName : courseNames) {
            Course course = new Course(courseName, courseName.replace(" ", "").toLowerCase());
            list.add(course);
        }
        return list;
    }

}
