package com.example.devhub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editHourlyPay, editAmountTime, editBudget;
    private Button btnCalculate, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editHourlyPay = findViewById(R.id.editHourlyPay);
        editAmountTime = findViewById(R.id.editAmountTime);
        editBudget = findViewById(R.id.editBudget);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnNext = findViewById(R.id.btnNext);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strPay = editHourlyPay.getText().toString().trim();
                String strTime = editAmountTime.getText().toString().trim();
                String strBudget = editBudget.getText().toString().trim();

                boolean hasPay = !strPay.isEmpty();
                boolean hasTime = !strTime.isEmpty();
                boolean hasBudget = !strBudget.isEmpty();

                if (hasPay && hasTime && !hasBudget) {
                    double pay = Double.parseDouble(strPay);
                    double time = Double.parseDouble(strTime);
                    double result = pay * time;
                    editBudget.setText(String.format("%.2f", result));
                }
                else if (hasPay && hasBudget && !hasTime) {
                    double pay = Double.parseDouble(strPay);
                    double budget = Double.parseDouble(strBudget);
                    if (pay > 0) {
                        double result = budget / pay;
                        editAmountTime.setText(String.format("%.2f", result));
                    } else {
                        Toast.makeText(MainActivity.this, "Hourly pay cannot be zero", Toast.LENGTH_SHORT).show();
                    }
                }
                else if (hasTime && hasBudget && !hasPay) {
                    double time = Double.parseDouble(strTime);
                    double budget = Double.parseDouble(strBudget);
                    if (time > 0) {
                        double result = budget / time;
                        editHourlyPay.setText(String.format("%.2f", result));
                    } else {
                        Toast.makeText(MainActivity.this, "Time cannot be zero", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Please fill exactly 2 fields to calculate the 3rd", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProjectListActivity.class);
                startActivity(intent);
            }
        });
    }
}