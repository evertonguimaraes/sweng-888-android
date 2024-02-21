package edu.psu.sweng888.lessonfour_data.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import edu.psu.sweng888.lessonfour_data.R;

public class SelectionActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButtonFullListMovies;
    private Button mButtonMoviesByCategory;
    private Spinner mSpinnerMovies;

    private final String KEY_OPTION_SELECTED = "option_selected";

    private String MOVIES_OPTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        mButtonFullListMovies = findViewById(R.id.button_all_movies);
        mButtonMoviesByCategory = findViewById(R.id.button_by_category_movies);

        mSpinnerMovies =findViewById(R.id.spinner_movie_category);

        mButtonFullListMovies.setOnClickListener(this);
        mButtonMoviesByCategory.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button_all_movies: MOVIES_OPTION = "all"; break;
            case R.id.button_by_category_movies: MOVIES_OPTION = mSpinnerMovies.getSelectedItem().toString(); break;
            default: break;
        }

        if (MOVIES_OPTION.equals("---"))
            Toast.makeText(this, "Select a valid option", Toast.LENGTH_SHORT).show();
        else{
            Intent intent = new Intent(SelectionActivity.this, MainActivity.class);
            intent.putExtra(KEY_OPTION_SELECTED, MOVIES_OPTION);
            startActivity(intent);
        }
    }
}