package com.maxwel.teladelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaBoasVindas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_boas_vindas);

        TextView bv = (TextView) findViewById(R.id.txtBoasVindas);
        Intent it = this.getIntent();
        if (it != null) {
            String nome = it.getStringExtra("nome");
            if (nome.length() == 0) {
                nome = "Desconhecido";
            }
            bv.setText("Bem Vindo(a), "+nome);
        }

        Button btSair = (Button) findViewById(R.id.btVoltar);
        btSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent( v.getContext(), MainActivity.class);
                startActivity(it);
            }
        });
    }
}