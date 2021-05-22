package com.maxwel.teladelogin;

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

        final EditText etNome = (EditText) findViewById(R.id.campoUsuario);
        final EditText etSenha = (EditText) findViewById(R.id.campoSenha);

        final TextView erro = (TextView) findViewById(R.id.avisoDeErro);

        Button btEntrar = (Button) findViewById(R.id.btLogar);
        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = etNome.getText().toString();
                String senha = etSenha.getText().toString();
                if ((nome.equals("root")) && (senha.equals("admin"))) {
                    Intent it = new Intent( v.getContext(), TelaBoasVindas.class);
                    Bundle params = new Bundle();
                    it.putExtra("nome", nome);
                    it.putExtra("senha", senha);
                    startActivity(it);
                } else { erro.setText("Erro: usuário ou senha inválidos !");}
            }
        });
    }
}