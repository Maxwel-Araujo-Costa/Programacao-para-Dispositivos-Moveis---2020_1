package com.maxwel.aula15_intentssomar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Somador extends AppCompatActivity {

    public static final int nums = 0;
    String Num1 = "2";
    String Num2 = "3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent it = this.getIntent();
        Num1 = it.getStringExtra("first");
        Num2 = it.getStringExtra("second");

        Intent intent = new Intent();
        Double firstNu = Double.parseDouble(Num1);
        Double secondNu = Double.parseDouble(Num2);
        Double result = firstNu + secondNu;
        intent.putExtra("somaResul", result.toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}