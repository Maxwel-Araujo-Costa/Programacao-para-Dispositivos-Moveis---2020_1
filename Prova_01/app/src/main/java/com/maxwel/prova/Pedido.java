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

public class Pedido extends AppCompatActivity {
    public TextView conta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
        List<ItemCardapio> newCarrinho= new ArrayList<>();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            getIntent().getExtras();
            newCarrinho = (List<ItemCardapio>) bundle.getSerializable("ARRAYLIST");
            ItemCardapio.setCarrinho(newCarrinho);
        }
        final PedidoAdapter adap = new PedidoAdapter(this,ItemCardapio.getCarrinho());
        double ValorTotal =0;
        for (int i=0;i <= (newCarrinho.size() -1); i++){
            ItemCardapio item = (ItemCardapio) adap.getItem(i);
            ValorTotal +=item.preco * item.quantidade;
        }
        setContentView(R.layout.activity_pedido);
        TextView Vf = (TextView) findViewById(R.id.tvValorFinal);
        double arredonda2 = (double) Math.round((ValorTotal) * 100) / 100;
        Vf.setText("O seu pedido ficou em: R$ "+arredonda2);
        final ListView lv = (ListView) findViewById(R.id.lvPedidoCarrinho);
        lv.setAdapter(adap);

        Toolbar tool = (Toolbar) findViewById(R.id.toolbarCarrinho);
        setSupportActionBar(tool);

        conta = (TextView) findViewById(R.id.cont);
        conta.setText("Número total de items no pedido: "+newCarrinho.size());

        Button btFinal = (Button) findViewById(R.id.btnPagar);
        btFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Obrigado por testar este aplicativo, " +
                        "mas as formas de pagamento ainda não foram implementadas.",
                        Toast.LENGTH_LONG).show();
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
            case R.id.action_cart:
                List<ItemCardapio> data = new ArrayList<>();
                Bundle bundle = getIntent().getExtras();
                getIntent().getExtras();
                data = (List<ItemCardapio>) bundle.getSerializable("ARRAYLIST");
                Intent intent2 = new Intent(getApplicationContext(),Carrinho.class);
                Bundle b = new Bundle();
                b.putSerializable("ARRAYLIST", (Serializable) data);
                intent2.putExtras(b);
                startActivity(intent2);
                return true;
            default:
                return false;
        }
    }
}
