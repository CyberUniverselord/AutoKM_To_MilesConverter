package com.sylabblueprint.autokm_to_milesconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    String flag;

    final DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editKM = findViewById(R.id.editKM);
        final EditText editMiles = findViewById(R.id.editMiles);
        final TextView textResult = findViewById(R.id.textResult);


        //KmToMiles
        editKM.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0){
                    double value = Double.parseDouble(s.toString());
                    textResult.setText(convertKmToMiles(value) + flag);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //MilesToKm
        editMiles.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0){
                    double value = Double.parseDouble(s.toString());
                    textResult.setText(convertMilesToKm(value) + flag);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    public String convertKmToMiles(double value){
        double flagMessage = (value * 0.62173);
        if (flagMessage>1){
            flag = " Miles";
        }else{
            flag = " Mile";
        }

        String result = df.format(flagMessage);
        return result;
    }

    public String convertMilesToKm(double value){
        double flagMessage = (value * 1.62173);
        if (flagMessage>1){
            flag = " Kilometers";
        }else{
            flag = " Kilometer";
        }
        String result = df.format(flagMessage);
        return result;
    }

}
