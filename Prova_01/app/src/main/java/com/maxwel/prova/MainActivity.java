package com.maxwel.prova;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Serializable, AdapterView.OnItemLongClickListener {
    public List<ItemCardapio> card=new ArrayList<ItemCardapio>();
    public TextView conta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardapioAdapter adap = new CardapioAdapter(this,ItemCardapio.getCardapio());
        ListView lv = (ListView) findViewById(R.id.lvCardapio);
        lv.setAdapter(adap);
        lv.setOnItemLongClickListener(this);
        conta = (TextView) findViewById(R.id.cont);

        Toolbar tool = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tool);

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
    public boolean onItemLongClick(AdapterView<?> lv, View v, int pos, long id) {
        ItemCardapio item = (ItemCardapio) lv.getAdapter().getItem(pos);
        if(card.contains(item)){
            Toast.makeText(getApplicationContext(), "Este item já está no pedido !" ,Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), "Escolhido o item: "+item.nome ,Toast.LENGTH_SHORT).show();
            card.add(item);
            conta.setText("Número total de items no carrinho: "+card.size());
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_cart:
                List<ItemCardapio> data = new ArrayList<>();
                data = card;
                Intent intent = new Intent(getApplicationContext(),Carrinho.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("ARRAYLIST", (Serializable) data);
                intent.putExtras(bundle);
                startActivity(intent);
                return true;
            default:
                return false;
        }
    }



}