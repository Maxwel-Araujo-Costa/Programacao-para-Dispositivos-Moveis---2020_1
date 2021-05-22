package com.maxwel.prova;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Carrinho extends AppCompatActivity implements Serializable {
    public TextView conta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);
        List<ItemCardapio> newCarrinho= new ArrayList<>();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            getIntent().getExtras();
            newCarrinho = (List<ItemCardapio>) bundle.getSerializable("ARRAYLIST");
            ItemCardapio.setCarrinho(newCarrinho);
        }
        conta = (TextView) findViewById(R.id.cont);
        conta.setText("Número total de items no carrinho: "+newCarrinho.size());
        final CarroAdapter adap = new CarroAdapter(this,ItemCardapio.getCarrinho());
        final ListView lv = (ListView) findViewById(R.id.lvCardapioCarrinho);
        lv.setAdapter(adap);

        Toolbar tool = (Toolbar) findViewById(R.id.toolbarCarrinho);
        setSupportActionBar(tool);

        Button btFinal = (Button) findViewById(R.id.btnPedido);
        final List<ItemCardapio> finalCarrinho = newCarrinho;
        btFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<ItemCardapio> data = new ArrayList<>();
                data = finalCarrinho;
                Intent it = new Intent( v.getContext(), Pedido.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("ARRAYLIST", (Serializable) data);
                it.putExtras(bundle);
                startActivity(it);
            }
        });

    }
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.novos_botoes,menu);
        if(menu instanceof MenuBuilder){
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return false;
        }
    }
}
