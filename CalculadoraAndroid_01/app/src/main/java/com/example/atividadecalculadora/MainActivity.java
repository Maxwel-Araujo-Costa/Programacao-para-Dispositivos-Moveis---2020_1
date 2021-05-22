package com.example.atividadecalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button addition, subtraction, multiplication, division, clear;
    private EditText primeiro, segundo;
    private TextView resposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addition = findViewById(R.id.somar);
        subtraction = findViewById(R.id.subtrair);
        multiplication = findViewById(R.id.multiplicar);
        division = findViewById(R.id.dividir);
        clear = findViewById(R.id.limpar);

        primeiro = findViewById(R.id.firstNumber);
        segundo = findViewById(R.id.secondNumber);
        resposta = findViewById(R.id.resultadoShow);
    }

    public void add(View view){
        String first = primeiro.getText().toString().trim();
        String second = segundo.getText().toString().trim();
        Double firstNu = Double.parseDouble(first);
        Double secondNu = Double.parseDouble(second);
        Double result = firstNu + secondNu;
        resposta.setText(result.toString());
    }
    public void sub(View view){
        String first = primeiro.getText().toString().trim();
        String second = segundo.getText().toString().trim();
        Double firstNu = Double.parseDouble(first);
        Double secondNu = Double.parseDouble(second);
        Double result = firstNu - secondNu;
        resposta.setText(result.toString());
    }
    public void mult(View view){
        String first = primeiro.getText().toString().trim();
        String second = segundo.getText().toString().trim();
        Double firstNu = Double.parseDouble(first);
        Double secondNu = Double.parseDouble(second);
        Double result = firstNu * secondNu;
        resposta.setText(result.toString());
    }
    public void divd(View view){
        String first = primeiro.getText().toString().trim();
        String second = segundo.getText().toString().trim();
        Double firstNu = Double.parseDouble(first);
        Double secondNu = Double.parseDouble(second);
        Double result = firstNu / secondNu;
        resposta.setText(result.toString());
    }

    public void erase(View view){
        primeiro.setText("");
        segundo.setText("");
        resposta.setText("");
    }
}