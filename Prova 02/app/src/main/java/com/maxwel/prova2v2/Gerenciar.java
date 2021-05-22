package com.maxwel.prova2v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Gerenciar extends AppCompatActivity {
    private Button voltar, novoItem;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenciar);
        voltar = (Button) findViewById(R.id.btnVoltarGerenciar);
        novoItem = (Button) findViewById(R.id.btnNovoGerenciar);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent( v.getContext(), MainActivity.class);
                startActivity(it);
            }
        });
        novoItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent( v.getContext(), Editar.class);
                it.putExtra("Função","novo");
                startActivity(it);
            }
        });

        ListView lv = (ListView) findViewById(R.id.lvGerenciar);
        GerenciarAdapter adap = new GerenciarAdapter(this,ItemGerenciar.getGerenciar());
        lv.setAdapter(adap);
    }
}