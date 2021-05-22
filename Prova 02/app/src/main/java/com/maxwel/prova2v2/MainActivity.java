package com.maxwel.prova2v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button gerenciar, novo, historico, popular;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gerenciar = (Button) findViewById(R.id.btnGerenciarCardapio);
        novo = (Button) findViewById(R.id.btnNovo);
        historico = (Button) findViewById(R.id.btnHistorico);
        popular = (Button) findViewById(R.id.btnPopular);

        gerenciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent( v.getContext(), Gerenciar.class);
                startActivity(it);
            }
        });
        novo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent( v.getContext(), Cardapio.class);
                startActivity(it);
            }
        });
        historico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent( v.getContext(), Historico.class);
                startActivity(it);
            }
        });
        popular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = new DBHelper(getBaseContext());
                Log.i("RegistroBD","-------------Inserindo-------------");

                db.insere_registro("Batata Frita", 2.19, 1, R.drawable.batata_frita);
                db.insere_registro("Batata Recheada com Cream Cheese e Bacon", 2.79,
                        1,R.drawable.batata_recheada_com_cream_cheese_e_bacon);
                db.insere_registro("Big Bacon Triplo Classico", 8.09,1,R.drawable.big_bacon_triplo_classico);
                db.insere_registro("Sanduiche Picante de Frango Empanado",
                        0.99,1,R.drawable.sanduiche_picante_de_frango_empanado);
                db.insere_registro("Salada Taco", 4.69,1,R.drawable.salada_taco);
                db.insere_registro("Coca Cola", 2.19,1,R.drawable.coca_cola);
                db.insere_registro("Sprite", 2.19,1,R.drawable.sprite);
                db.insere_registro("Café", 1.49,1,R.drawable.cafe);
                db.recupera_todos_registros();
            }
        });
    }
    public byte[] imagemParaBytes(String img) throws IOException {
        File file = new File(img);
        ByteArrayOutputStream ous = null;
        InputStream ios = null;
        try {
            byte[] buffer = new byte[4096];
            ous = new ByteArrayOutputStream();
            ios = new FileInputStream(file);
            int read = 0;
            while ((read = ios.read(buffer)) != -1) {
                ous.write(buffer, 0, read);
            }
        }finally {
            try {
                if (ous != null)
                    ous.close();
            } catch (IOException e) {
            }

            try {
                if (ios != null)
                    ios.close();
            } catch (IOException e) {
            }
        }
        return ous.toByteArray();
    }
    public byte[] imagemParaBytes2(String img){

        InputStream is = this.getClass().getResourceAsStream( img);
        int i, len=0;
        byte bArray[] = new byte[500];
        byte bArray2[];
        byte b[] = new byte[1];
        try {

            while ( is.read(b) != -1 ){
                if ( len+1 >= bArray.length ){
                    bArray2 = new byte[bArray.length];
                    for ( i = 0; i < len; i++ ){
                        bArray2[i] = bArray[i];
                    }
                    bArray = new byte[bArray2.length+500];
                    for ( i = 0; i < len; i++ ){
                        bArray[i] = bArray2[i];
                    }
                }
                bArray[len] = b[0];
                len++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bArray;
    }


}