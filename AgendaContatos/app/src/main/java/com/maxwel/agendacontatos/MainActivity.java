package com.maxwel.agendacontatos;


import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBHelper(getBaseContext());

        /*Log.i("RegistroBD","-------------Inserindo-------------");
        db.insere_registro("Sr. Teste da Sila", "(11)5555-5555");
        db.insere_registro("Sra. Silvia Teste", "(11)6666-5555");
        db.insere_registro("Sr. Teste da Fonseca", "(11)3333-3333");
        Log.i("RegistroBD","-------------Recuperando-------------");
        db.recupera_todos_registros();
        Log.i("RegistroBD","-------------Atualizando-------------");
        db.atualiza_registro("2","Sra. Silvia Teste", "(11)6666-6666");
        Log.i("RegistroBD","-------------Excluindo-------------");
        db.exclui_registro("3");
        Log.i("RegistroBD","-------------Recuperando-------------");
        db.recupera_todos_registros();*/
    }
}