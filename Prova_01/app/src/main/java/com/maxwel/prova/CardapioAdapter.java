package com.maxwel.prova;

import android.app.AlertDialog;
import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CardapioAdapter extends BaseAdapter{
    private Context context;
    private List<ItemCardapio> cardapio;

    public CardapioAdapter(Context count, List<ItemCardapio> card){
        this.context = count;
        this.cardapio = card;
    }

    @Override
    public int getCount() {
        return cardapio.size();
    }

    @Override
    public Object getItem(int position) {
        return cardapio.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemcardapio,parent,false);
        ImageView img = (ImageView) view.findViewById(R.id.ivItem);
        TextView tvItem = (TextView) view.findViewById(R.id.tvItem);
        TextView tvItemPreco = (TextView) view.findViewById(R.id.tvItemPreco);
        ItemCardapio item = cardapio.get(position);
        img.setImageResource(item.imagem);
        tvItem.setText(item.nome);
        tvItemPreco.setText("R$ "+item.preco);

        return view;
    }
}
