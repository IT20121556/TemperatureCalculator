package com.example.madtute02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText tv_temp;
    RadioButton rd_btn_C;
    RadioButton rd_btn_F;
    Button btn_Cal;
    TextView tv_calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_temp = findViewById(R.id.tv_temp);
        rd_btn_C = findViewById(R.id.rd_btn_C);
        rd_btn_F = findViewById(R.id.rd_btn_F);
        btn_Cal = findViewById(R.id.btn_Cal);
        tv_calculate = findViewById(R.id.tv_calculate);
    }

    public void calculateAnswer(View view){

        Calculations cal = new Calculations();
        String value = tv_temp.getText().toString();

        if (TextUtils.isEmpty(value)){
            Toast.makeText(this, "Enter the Temperature!", Toast.LENGTH_SHORT).show();

        } else {
            Float temp = Float.parseFloat(value);
            if (rd_btn_C.isChecked()){
                temp = cal.convertCelciusToFahrenheit(temp);

            } else if (rd_btn_F.isChecked()){
                temp = cal.convertFahrenheitToCelcius(temp);
            } else {
                Toast.makeText(this, "Select one temp method!", Toast.LENGTH_SHORT).show();
                temp = 0.0f;
            }
            tv_calculate.setText(new Float(temp).toString());
        }

    }
}