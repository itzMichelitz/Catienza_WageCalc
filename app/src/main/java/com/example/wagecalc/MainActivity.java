package com.example.wagecalc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wagecalc.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextHourlyRate;
    private EditText editTextHoursWorked;
    private Button buttonCalculate;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editTextHourlyRate = findViewById(R.id.editTextHourlyRate);
        editTextHoursWorked = findViewById(R.id.editTextHoursWorked);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        // Set click listener for the calculate button
        buttonCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonCalculate) {
            calculateWage();
        }
    }

    private void calculateWage() {
        // Get the input values
        String hourlyRateStr = editTextHourlyRate.getText().toString().trim();
        String hoursWorkedStr = editTextHoursWorked.getText().toString().trim();

        // Check if the input values are not empty
        if (hourlyRateStr.isEmpty() || hoursWorkedStr.isEmpty()) {
            textViewResult.setText("Please enter hourly rate and hours worked");
            return;
        }

        // Parse input values to double
        double hourlyRate = Double.parseDouble(hourlyRateStr);
        double hoursWorked = Double.parseDouble(hoursWorkedStr);

        // Calculate the wage
        double wage = hourlyRate * hoursWorked;

        // Display the result
        textViewResult.setText("Wage: $" + wage);
    }
}
