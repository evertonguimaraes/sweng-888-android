package edu.psu.sweng888.lessonfour_contentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;

public class SplashScreenActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        /** Configure and start the progress bar animation */
        mProgressBar = findViewById(R.id.splash_progress_bar);
        /** initialize the progress bar and animate it from 0% to 100% using an ObjectAnimator
         * object. The animation takes 4 seconds to complete and uses a decelerate interpolator
         * to give it a smoother animation */
        ObjectAnimator animation = ObjectAnimator.ofInt(mProgressBar, "progress", 0, 100);
        animation.setDuration(4000);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();

         /** We use a Handler object to delay the launch of the MainActivity by 4 seconds.
          * After 4 seconds, an intent is created to launch the MainActivity, and the finish()
          * method is called to destroy the splash screen activity. */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /** Start the next activity after a delay */
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 4000);
    }
}