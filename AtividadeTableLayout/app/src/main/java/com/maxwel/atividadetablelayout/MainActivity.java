package com.maxwel.atividadetablelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etNome = (EditText) findViewById(R.id.edtNome);
        final EditText etSenha = (EditText) findViewById(R.id.edtSenha);
        final EditText etRG = (EditText) findViewById(R.id.edtRG);
        final EditText etCPF = (EditText) findViewById(R.id.edtCPF);
        final EditText etUsuario = (EditText) findViewById(R.id.edtUsuario);


        Button btEnviar = (Button) findViewById(R.id.btEnviar);
        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = etNome.getText().toString();
                String senha = etSenha.getText().toString();
                String RG = etRG.getText().toString();
                String CPF = etCPF.getText().toString();
                String Usuario = etUsuario.getText().toString();
                Intent it = new Intent( v.getContext(), TelaTableLayout.class);
                Bundle params = new Bundle();
                it.putExtra("nome", nome);
                it.putExtra("senha", senha);
                it.putExtra("RG", RG);
                it.putExtra("CPF", CPF);
                it.putExtra("Usuario", Usuario);
                startActivity(it);
            }
        });
    }
}