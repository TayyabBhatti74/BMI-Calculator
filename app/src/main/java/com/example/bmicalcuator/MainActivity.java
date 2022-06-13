package com.example.bmicalcuator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.bmicalcuator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //View Binding
        ActivityMainBinding mainxml = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainxml.getRoot());

        mainxml.btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int we = Integer.parseInt(mainxml.etdWeight.getText().toString());
                int ft = Integer.parseInt(mainxml.edtFt.getText().toString());
                int in = Integer.parseInt(mainxml.edtIn.getText().toString());

                int totalIn = ft * 12 + in;
                double totalCm = totalIn * 2.54;
                double totalM = totalCm / 100;

                double bmi = we / (totalM * totalM);

                if (bmi < 18.5) {
                    mainxml.result.setText(R.string.UW);
                    mainxml.llMain.setBackgroundColor(getResources().getColor(R.color.UW));
                } else if (bmi < 24.9) {
                    mainxml.result.setText(R.string.H);
                    mainxml.llMain.setBackgroundColor(getResources().getColor(R.color.H));
                } else if (bmi < 29.9) {
                    mainxml.result.setText(R.string.OW);
                    mainxml.llMain.setBackgroundColor(getResources().getColor(R.color.OW));
                } else {
                    mainxml.result.setText(R.string.O);
                    mainxml.llMain.setBackgroundColor(getResources().getColor(R.color.O));
                }
            }
        });


    }
}