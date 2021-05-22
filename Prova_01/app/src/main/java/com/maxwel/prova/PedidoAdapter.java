package com.maxwel.prova;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

public class PedidoAdapter extends BaseAdapter {
    private Context context;
    private List<ItemCardapio> cardapio;

    public PedidoAdapter(Context count, List<ItemCardapio> card) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemfinal, parent, false);
        ImageView img = (ImageView) view.findViewById(R.id.ivItem);
        TextView tvItem = (TextView) view.findViewById(R.id.tvItem);
        TextView tvItemPreco = (TextView) view.findViewById(R.id.tvItemPreco);
        TextView tvNP = (TextView) view.findViewById(R.id.tvNp);
        ItemCardapio item = cardapio.get(position);
        img.setImageResource(item.imagem);
        tvItem.setText(item.nome);
        double arredonda2 = (double) Math.round((item.preco*item.quantidade) * 100) / 100;
        tvItemPreco.setText("R$ " + arredonda2);
        tvNP.setText(""+item.quantidade);
        return view;
    }

}
