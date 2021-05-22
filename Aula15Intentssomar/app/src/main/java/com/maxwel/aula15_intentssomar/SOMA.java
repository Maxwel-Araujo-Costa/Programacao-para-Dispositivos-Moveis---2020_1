package com.maxwel.aula15_intentssomar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SOMA extends AppCompatActivity {
    private Button addition, clear;
    private EditText primeiro, segundo;
    private TextView resposta;
    public static final int startSomador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addition = findViewById(R.id.somar);
        clear = findViewById(R.id.limpar);

        primeiro = findViewById(R.id.firstNumber);
        segundo = findViewById(R.id.secondNumber);
        resposta = findViewById(R.id.resultadoShow);
    }

    public void add(View view){
        String first = primeiro.getText().toString().trim();
        String second = segundo.getText().toString().trim();
        Intent it = new Intent("CUSTOM_INTENT");
        it.putExtra("first", first);
        it.putExtra("second", second);
        startActivityForResult(it, startSomador);
    }

    public void erase(View view){
        primeiro.setText("");
        segundo.setText("");
        resposta.setText("");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == startSomador) {
            if (resultCode == RESULT_OK) {

                String returnString = data.getStringExtra("somaResul");

                resposta.setText(returnString);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                resposta.setText("Erro");
            }
        }
    }

}