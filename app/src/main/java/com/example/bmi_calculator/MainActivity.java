package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText h,w;
        MaterialButton cal;
        TextView ans;

        w=findViewById(R.id.weightet);
        h=findViewById(R.id.hightet);
        cal=findViewById(R.id.btncal);
        ans=findViewById(R.id.ans);

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String height = h.getText().toString();
                String weight = w.getText().toString();

                if (height.equals("")  || weight.equals("") )
                {
                    Toast.makeText(MainActivity.this, "Please Enter all the Details", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    float hh = Float.parseFloat(height);
                    float ww = Float.parseFloat(weight);
                    float x = ww / (hh * hh);

                    if (x < 18.5) {
                        ans.setVisibility(View.VISIBLE);
                        ans.setText("BMI = " + x + "\nBelow Normal Weight");
                    } else if (x >= 18.5 && x < 25) {
                        ans.setVisibility(View.VISIBLE);
                        ans.setText("BMI = " + x + "\nNormal Weight");
                    } else if (x >= 18.5 && x < 30) {
                        ans.setVisibility(View.VISIBLE);
                        ans.setText("BMI = " + x + "\nOver Weight");
                    } else if (x >= 30 && x < 35) {
                        ans.setVisibility(View.VISIBLE);
                        ans.setText("BMI = " + x + "\nClass I Obesity");
                    } else if (x >= 35 && x < 40) {
                        ans.setVisibility(View.VISIBLE);
                        ans.setText("BMI = " + x + "\nClass II Obesity");
                    } else {
                        ans.setVisibility(View.VISIBLE);
                        ans.setText("BMI = " + x + "\nClass III Obesity");
                    }
                }

            }
        });
    }

}