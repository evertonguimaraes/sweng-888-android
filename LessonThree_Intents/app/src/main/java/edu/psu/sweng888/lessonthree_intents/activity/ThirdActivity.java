package edu.psu.sweng888.lessonthree_intents.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import edu.psu.sweng888.lessonthree_intents.R;
import edu.psu.sweng888.lessonthree_intents.model.Course;

public class ThirdActivity extends AppCompatActivity {

    private TextView mTextViewID;
    private TextView mTextViewCredits;
    private TextView mTextViewDescription;

    private Button mButtonPreviousActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        mButtonPreviousActivity = findViewById(R.id.id_back_button);
        mTextViewID = findViewById(R.id.course_id);
        mTextViewCredits = findViewById(R.id.course_credits);
        mTextViewDescription = findViewById(R.id.course_description);

        Intent intent = getIntent();
        Course selectedCourse = (Course) intent.getSerializableExtra("selectedCourse");

        mTextViewID.setText("SWENG: "+selectedCourse.getID());
        mTextViewCredits.setText("Credits: "+selectedCourse.getCredits());
        mTextViewDescription.setText("Description: "+selectedCourse.getDescription());

        mButtonPreviousActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
                intent.putExtra("RETURN_FROM_THIRD_ACTIVITY", true);
                startActivity(intent);
            }
        });
    }
}