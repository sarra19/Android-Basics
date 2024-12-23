package com.example.firstapp;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView resultTv;
    private EditText inputEt;
    private Button submitBtn;
    private Button simpleToastBtn, customToastBtn;
    RadioButton maleRb, femaleRb;
    String result;
    RadioGroup radioGroup;
    ToggleButton toggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleButton = findViewById(R.id.toggleBtn);

        // Initialize the views
        resultTv = findViewById(R.id.displaytxt);
        inputEt = findViewById(R.id.edit_text_id);
        submitBtn = findViewById(R.id.submitBtn);
        simpleToastBtn = findViewById(R.id.simpleToastBtn);
        customToastBtn = findViewById(R.id.customToastBtn);

        // Set the onClick listeners for the views
        resultTv.setOnClickListener(this);
        submitBtn.setOnClickListener(this);
        simpleToastBtn.setOnClickListener(this);
        customToastBtn.setOnClickListener(this);
        maleRb = findViewById(R.id.maleRb);
        femaleRb = findViewById(R.id.femaleRb);
        radioGroup = findViewById(R.id.radioGroup);
        // Set ToggleButton listener
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "On Wifi", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Off Wifi", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    ////process 1
//        submitBtn.setOnClickListener(new View. OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String result = inputEt.getText().toString();
//                resultTv.setText(result);
//
//
//            }
//        });

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.displaytxt) {
            // Display the Toast message when the TextView is clicked
            Toast.makeText(getApplicationContext(), "Result Done", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.submitBtn) {
            // Get text from EditText and set it to TextView
            String result = inputEt.getText().toString();
            resultTv.setText(result);
        } else if (v.getId() == R.id.simpleToastBtn) {
            // Show a simple Toast
            Toast.makeText(getApplicationContext(), "This is a simple Toast", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.customToastBtn) {
            // Show a custom Toast
            Toast toast = Toast.makeText(getApplicationContext(), "This is a custom Toast", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }

    public void showResult(View view) {

        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);
        result = radioButton.getText().toString();

//        if (maleRb.isChecked()) {
//            result = maleRb.getText().toString();
//        } else if (femaleRb.isChecked()) {
//            result = femaleRb.getText().toString();
//        } else {
//            result = "Nothing Selected";
//        }

        Toast.makeText(this, "" + result, Toast.LENGTH_SHORT).show();
    }



                }
