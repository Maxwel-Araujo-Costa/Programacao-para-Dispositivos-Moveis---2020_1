package com.maxwel.prova2v2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class ItemGerenciar implements Serializable {
    DBHelper db;
    public String nome;
    public int imagem;
    public double preco;
    public int quantidade;
    public int id;

    public ItemGerenciar (int id, String nome, double preco, int quantidade, int imagem){
        this.nome=nome;
        this.id=id;
        this.preco=preco;
        this.quantidade=quantidade;
        this.imagem= imagem;
    }

    public static List<ItemGerenciar> getGerenciar(){
        List<ItemGerenciar> gerenciar=new ArrayList<ItemGerenciar>();
        /*SQLiteDatabase database = db.getWritableDatabase();
        Cursor cursor = database.query("restaurante", new String[] {"_id","nome","valor","quantidade","imagem"},
                null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                ItemGerenciar item = new ItemGerenciar(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getDouble(2),
                        cursor.getInt(3),
                        cursor.getInt(4));
                gerenciar.add(item);
            } while (cursor.moveToNext());
        }*/
        ItemGerenciar item = new ItemGerenciar(0,"Batata Frita",2.19,1,R.drawable.batata_frita);
        gerenciar.add(item);
        return gerenciar;
    }
    public static List<ItemGerenciar> carrinho;
    public static List<ItemGerenciar> getCarrinho(){
        return carrinho;
    }
    public static void setCarrinho(List<ItemGerenciar> newCarrinho){
        carrinho=new ArrayList<ItemGerenciar>();
        carrinho = newCarrinho;
    }

}