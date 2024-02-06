package edu.psu.sweng888.lessonthreeintents.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.psu.sweng888.lessonthreeintents.R;
import edu.psu.sweng888.lessonthreeintents.model.Course;
import edu.psu.sweng888.lessonthreeintents.model.CourseListAdapter;

public class SecondActivity extends AppCompatActivity {

    private ListView mListViewCourses;
    private CourseListAdapter courseListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ArrayList<Course> courses = loadCoursesInfo();
        courseListAdapter = new CourseListAdapter(SecondActivity.this, courses);

        mListViewCourses = findViewById(R.id.listview_courses);
        mListViewCourses.setAdapter(courseListAdapter);
        mListViewCourses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Course selectedCourse = (Course) parent.getItemAtPosition(position);
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putExtra("selectedCourse", selectedCourse);
                startActivity(intent);
            }
        });
    }

    private ArrayList<Course> loadCoursesInfo(){

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course(888, 3, "Mobile Computing"));
        courses.add(new Course(894, 6, "Capstone"));
        courses.add(new Course(861, 3, "Software Construction"));
        courses.add(new Course(837, 3, "Software Systems Architecture"));
        courses.add(new Course(587, 3, "Software Systems Design"));

        return courses;
    }

    @Override
    protected void onResume() {
        super.onResume();
        boolean returnFromThirdActivity = getIntent().getBooleanExtra("RETURN_FROM_THIRD_ACTIVITY", false);

        if (returnFromThirdActivity) {
            Toast.makeText(this, "Welcome back from ThirdActivity", Toast.LENGTH_SHORT).show();
        }
    }
}