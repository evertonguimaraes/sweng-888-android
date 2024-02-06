package edu.psu.sweng888.lessonthree_intents.activity;

import static android.Manifest.permission.CALL_PHONE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import edu.psu.sweng888.lessonthree_intents.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private ImageView mImageView;
    private Button mButtonOpenDialer;
    private Button mButtonSendEmail;
    private Button mButtonSetAlarm;
    private Button mButtonListCourses;
    private Button mButtonOpenFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.imageViewAvatar);
        mImageView.setImageResource(R.mipmap.ic_alien);

        mButtonOpenDialer = findViewById(R.id.buttonMakeCall);
        mButtonSendEmail = findViewById(R.id.buttonSendEmail);
        mButtonSetAlarm = findViewById(R.id.buttonSetAlarm);
        mButtonOpenFile = findViewById(R.id.buttonOpenFile);
        mButtonListCourses = findViewById(R.id.buttonCheckListCourses);

        /** Defining the OnCLickListener for all the Buttons */
        mButtonOpenDialer.setOnLongClickListener(this);
        mButtonSendEmail.setOnClickListener(this);
        mButtonSetAlarm.setOnClickListener(this);
        mButtonListCourses.setOnClickListener(this);
        mButtonOpenFile.setOnClickListener(this);

        /** Set the OnLongCLickListener for the OpenDialer Button */
        mButtonOpenDialer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.buttonMakeCall: openDialer(); break; // DONE
            case R.id.buttonSendEmail: sendEmail(); break; // DONE
            case R.id.buttonSetAlarm: setAlarm();break; // DONE
            case R.id.buttonCheckListCourses: showListCourses(); break; // DONE
            default: break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        makeCall();
        return false;
    }

    private void makeCall(){
        Intent intent = new Intent(Intent.ACTION_CALL);
        String phoneNumber = "6106483224";
        intent.setData(Uri.parse("tel:" + phoneNumber));

        /** As a good practice, we need to check if the permission was granted by the user
         * If the permission is granted, it will start the activity;
         * Otherwise, it will request the permission to perform the CALL_PHONE action */
        if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) ==
                PackageManager.PERMISSION_GRANTED) {
            startActivity(intent);
        } else
            requestPermissions(new String[]{CALL_PHONE}, 1);

        /** It will check if the Package Manager has an active instance
         * THe Package Managed helps in solving any dependencies with classes, services, etc.
         * It is also able to install or uninstall any required package depending on the component used */
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void openDialer(){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        if (intent.resolveActivity(getPackageManager() )!= null){
            startActivity(intent);
        }
    }

    private void sendEmail(){
        String subject = "Mobile Computing";
        String message = "Composing a new email";
        String email = "evertontguimaraes@gmail.com";

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, email);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void setAlarm(){
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_HOUR, 19);
        intent.putExtra(AlarmClock.EXTRA_MINUTES, 7);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Class Break");
        startActivity(intent);
    }

    private void showListCourses(){
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        startActivity(intent);
    }
}