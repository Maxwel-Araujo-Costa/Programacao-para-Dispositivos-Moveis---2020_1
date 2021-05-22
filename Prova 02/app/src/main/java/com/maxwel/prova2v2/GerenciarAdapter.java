package com.maxwel.prova2v2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

public class GerenciarAdapter extends BaseAdapter {
    private Context context;
    private List<ItemGerenciar> gerenciar;
    private int REQUEST_CODE=1;
    DBHelper db;
    private View.OnClickListener o;

    public GerenciarAdapter(Context count, List<ItemGerenciar> geren){
        this.context = count;
        this.gerenciar = geren;
    }

    @Override
    public int getCount() {
        return gerenciar.size();
    }

    @Override
    public Object getItem(int position) {
        return gerenciar.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final View view = LayoutInflater.from(context).inflate(R.layout.itemgerenciar,parent,false);
        ImageView img = (ImageView) view.findViewById(R.id.ivItem);
        TextView tvItem = (TextView) view.findViewById(R.id.tvItem);
        TextView tvItemPreco = (TextView) view.findViewById(R.id.tvItemPreco);
        Button btnEditar = (Button) view.findViewById(R.id.btnEditarItemGerenciar);
        Button btnRemover = (Button) view.findViewById(R.id.btnRemoverItemGerenciar);
        final ItemGerenciar item = gerenciar.get(position);
        img.setImageResource(item.imagem);
        tvItem.setText(item.nome);
        tvItemPreco.setText("R$ "+item.preco);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity origin = (Activity)context;
                String funcao = "Editar";
                Intent it = new Intent(context, Editar.class);
                it.putExtra("Função",funcao);
                it.putExtra("Posição",position);
                origin.startActivity(it);
            }
        });
        btnRemover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.exclui_registro(String.valueOf(item.id));
                Iterator itr = gerenciar.iterator();
                while (itr.hasNext())
                {
                    int x = (Integer)itr.next();
                    if (x == item.id)
                        itr.remove();
                }
            }
        });
        return view;
    }

}