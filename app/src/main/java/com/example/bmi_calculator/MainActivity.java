package com.example.bmi_calculator;

import static com.example.bmi_calculator.R.id.llMain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtResult;
        Button btnCalculate;
        EditText edt_wight,edt_htft,edt_htin;
        LinearLayout llMain;

        edt_wight=findViewById(R.id.edt_weight);
        edt_htft=findViewById(R.id.edt_height_ft);
        edt_htin=findViewById(R.id.edt_height_in);
        btnCalculate=findViewById(R.id.btnCalculate);
        txtResult=findViewById(R.id.txtResult);
        llMain=findViewById(R.id.llMain);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt=Integer.parseInt(edt_wight.getText().toString());
                int ft=Integer.parseInt(edt_htft.getText().toString());
                int in=Integer.parseInt(edt_htin.getText().toString());

                int totalIn=ft * 12 + in;

                double totalCm=totalIn*2.53;

                double totalm=totalCm/100;

                double bmi=wt/(totalm*totalm);

                if(bmi>25){

                    txtResult.setText("You are over weight.");
                    llMain.setBackgroundColor(getResources().getColor(R.color.red_weight));

                }
                else if(bmi<18){
                    txtResult.setText("You are underweight.");
                    llMain.setBackgroundColor(getResources().getColor(R.color.yellow_uw));
                }
                else{
                    txtResult.setText("You are Healthy.");
                    llMain.setBackgroundColor(getResources().getColor(R.color.green_healthy));
                }

            }
        });

    }
}