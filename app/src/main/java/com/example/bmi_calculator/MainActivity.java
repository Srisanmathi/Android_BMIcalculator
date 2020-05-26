//Homework 01
//Abinaya Vaidhyanathan 801083111
//Srisanamthi Ramachandran 801060072

package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText et_weight;
    private EditText et_feet;
    private EditText et_inches;
    private Button bt_calculate;
    private TextView tv_yourBmi;
    private TextView tv_result;
    private  float weight, bmi;
    private int feet, inches;
    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("BMI Calculator");

        et_weight = findViewById(R.id.et_weight);
        et_feet = findViewById(R.id.et_feet);
        et_inches = findViewById(R.id.et_inches);
        bt_calculate = findViewById(R.id.bt_calculate);
        tv_yourBmi = findViewById(R.id.tv_yourbmi);
        tv_result = findViewById(R.id.tv_result);

        tv_yourBmi.setVisibility(View.INVISIBLE);
        tv_result.setVisibility(View.INVISIBLE);

        bt_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_weight.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Invalid Inputs",Toast.LENGTH_SHORT).show();
                    et_weight.setError("Weight cannot be null");
                }
                else {
                    weight = Float.parseFloat(et_weight.getText().toString());
                }
                if(et_feet.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Invalid Inputs",Toast.LENGTH_SHORT).show();
                    et_feet.setError("Height cannot be null");
                }
                else{
                    feet = Integer.parseInt(et_feet.getText().toString());
                }
                if(et_inches.getText().toString().equals("") || Integer.parseInt(et_inches.getText().toString())>12){
                    Toast.makeText(getApplicationContext(),"Invalid Inputs",Toast.LENGTH_SHORT).show();
                    et_inches.setError("cannot be null or greater than 12 ");
                    et_inches.setText("");
                }
                else{
                    inches = Integer.parseInt(et_inches.getText().toString());
                }


                 inches = (feet * 12) + inches;
                 bmi = (weight/(inches*inches))*703;
                 DecimalFormat f = new DecimalFormat("##.00");
                 if(bmi <= 18.5)
                     result = "Underweight";
                 else if(bmi>18.5 && bmi<=24.9)
                     result = "Normal Weight";
                 else if(bmi>=25 && bmi<=29.9)
                     result = "Overweight";
                 else
                     result = "Obese";

                 tv_yourBmi.setText("Your BMI:" + f.format(bmi));
                 tv_yourBmi.setVisibility(view.VISIBLE);
                 tv_result.setText("You are "+ result );
                 tv_result.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(),"BMI calculated",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
