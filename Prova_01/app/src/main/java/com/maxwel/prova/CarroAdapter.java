package com.maxwel.prova;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.List;

public class CarroAdapter extends BaseAdapter {
    private Context context;
    private List<ItemCardapio> cardapio;
    private int[] quantidade;

    public CarroAdapter(Context count, List<ItemCardapio> card) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.itemcarro, parent, false);
        ImageView img = (ImageView) view.findViewById(R.id.ivItem);
        TextView tvItem = (TextView) view.findViewById(R.id.tvItem);
        final TextView tvItemPreco = (TextView) view.findViewById(R.id.tvItemPreco);
        final NumberPicker npItem = (NumberPicker) view.findViewById(R.id.npItem);
        final ItemCardapio item = cardapio.get(position);
        img.setImageResource(item.imagem);
        tvItem.setText(item.nome);
        npItem.setMaxValue(99);
        npItem.setMinValue(1);
        npItem.setWrapSelectorWheel(true);
        npItem.setValue(item.quantidade);

        double arredonda2 = (double) Math.round((item.preco*item.quantidade) * 100) / 100;
        tvItemPreco.setText("R$ " + arredonda2);
        npItem.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                item.quantidade = npItem.getValue();
                double arredonda2 = (double) Math.round((item.preco*item.quantidade) * 100) / 100;
                tvItemPreco.setText("R$ " + arredonda2);
            }
        });

        return view;
    }

}
