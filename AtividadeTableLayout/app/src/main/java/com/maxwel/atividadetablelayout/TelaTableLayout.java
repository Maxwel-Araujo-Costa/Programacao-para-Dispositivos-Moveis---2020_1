package com.maxwel.atividadetablelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TelaTableLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_table_layout);

        Intent it = this.getIntent();

        TextView nm = (TextView) findViewById(R.id.txtNome);
        TextView rg = (TextView) findViewById(R.id.txtRG);
        TextView cpf = (TextView) findViewById(R.id.txtCPF);
        TextView usu = (TextView) findViewById(R.id.txtUsuario);
        TextView sn = (TextView) findViewById(R.id.txtSenha);
        if (it != null) {
            String nome = it.getStringExtra("nome");
            if (nome.length() == 0) {
                nome = "Desconhecido";
            }
            nm.setText("Nome: "+nome);

            String crg = it.getStringExtra("RG");
            if (crg.length() == 0) {
                crg = "Desconhecido";
            }
            rg.setText("RG: "+crg);

            String ccpf = it.getStringExtra("CPF");
            if (ccpf.length() == 0) {
                ccpf = "Desconhecido";
            }
            cpf.setText("CPF: "+ccpf);

            String usuario = it.getStringExtra("Usuario");
            if (usuario.length() == 0) {
                usuario = "Desconhecido";
            }
            usu.setText("Usuario: "+usuario);

            String senha = it.getStringExtra("senha");
            if (senha.length() == 0) {
                senha = "Desconhecido";
            }
            usu.setText("Senha: "+senha);
        }
    }
}