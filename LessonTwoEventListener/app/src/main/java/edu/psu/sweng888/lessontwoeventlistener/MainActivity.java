package edu.psu.sweng888.lessontwoeventlistener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewTitle;
    private TextView mTextViewResult;
    private EditText mEditTextNumber;
    private Button mButtonCheckIfPrime;
    private Button mButtonDeleteNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Wiring Up the UI elements to the corresponding variables */
        mTextViewTitle = findViewById(R.id.textViewTitle);
        mTextViewResult = findViewById(R.id.textViewResult);
        mEditTextNumber = findViewById(R.id.editTextNumber);
        mButtonCheckIfPrime = findViewById(R.id.buttonCheckPrimeNumber);
        mButtonDeleteNumber = findViewById(R.id.buttonEraseNumberDelete);

        /** Defining an Anonymous OnLongClickListener for the button */
        mButtonCheckIfPrime.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mTextViewResult.setText(checkIfPrime());
                mTextViewResult.setVisibility(View.VISIBLE);

                /** Since we are not using the callback, we set the return as false. */
                return false;
            }
        });

        /** Setting the listener for both buttons */
        mButtonCheckIfPrime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, checkIfPrime(), Toast.LENGTH_SHORT).show();
            }
        });
        mButtonDeleteNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteContentFromView();
            }
        });
    }

    private String checkIfPrime(){
        // Get the text from the UI
        String numberString = mEditTextNumber.getText().toString();
        int number = Integer.parseInt(numberString);
        // Check if prime
        boolean isPrime = isPrime(number);
        // Display the results in the TextView
        String result = isPrime ? "is Prime" : "is Not Prime";
        String msg = "The number "+number+" "+result;
        return msg;
    }

    private void deleteContentFromView(){
        if (!mTextViewResult.getText().toString().isEmpty())
            mTextViewResult.setText("");

        mEditTextNumber.setText("");
        String msg = "The number was deleted";
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    private boolean isPrime(int number) {
        if (number <= 1)
            return false;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}