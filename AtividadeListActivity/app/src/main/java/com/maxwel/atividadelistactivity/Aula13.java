package com.maxwel.atividadelistactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Aula13 extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] tl = {"Tela 1", "Tela 2", "Tela 3", "Tela 4"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tl);

        setListAdapter(adaptador);
    }

    public void onListItemClick(ListView lv, View v, int pos, long id){
        String tela = lv.getAdapter().getItem(pos).toString();

        switch (pos){
            case 0:
                Intent um = new Intent( v.getContext(), Tela1.class);
                startActivity(um);
                break;
            case 1:
                Intent dois = new Intent( v.getContext(), Tela2.class);
                startActivity(dois);
                break;
            case 2:
                Intent tres= new Intent( v.getContext(), Tela3.class);
                startActivity(tres);
                break;
            case 3:
                Intent quatro = new Intent( v.getContext(), Tela4.class);
                startActivity(quatro);
                break;
        }
    }
}