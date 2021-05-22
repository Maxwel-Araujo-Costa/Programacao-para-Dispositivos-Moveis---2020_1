package com.maxwel.prova2v2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public final static String NOME_BANCO = "BANCO_RESTAURANTE";
    public final static int VERSAO_BANCO = 1;

    public DBHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE restaurante (_id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, valor DOUBLE, quantidade INTEGER, imagem INTEGER);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS restaurante");
        onCreate(db);
    }

    public void insere_registro(String nome,Double valor, int quantidade, int imagem){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues valores_para_inserir_no_banco = new ContentValues();
        valores_para_inserir_no_banco.put("nome", nome);
        valores_para_inserir_no_banco.put("valor", valor);
        valores_para_inserir_no_banco.put("quantidade", quantidade);
        valores_para_inserir_no_banco.put("imagem", imagem);

        database.insert("restaurante", null, valores_para_inserir_no_banco);

        database.close();
    }

    public void atualiza_registro(String id, String nome, Double valor, int quantidade, int imagem){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put("_id",id);
        content.put("nome",nome);
        content.put("valor",valor);
        content.put("quantidade",quantidade);
        content.put("imagem",imagem);

        database.update("restaurante", content, "_id=?", new String[]{id});

        database.close();
    }

    public  void  recupera_todos_registros(){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query("restaurante", new String[] {"_id","nome","valor","quantidade"},
                null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                String id = cursor.getString(cursor.getColumnIndex("_id"));
                String nome = cursor.getString(cursor.getColumnIndex("nome"));
                Double valor = cursor.getDouble(cursor.getColumnIndex("valor"));
                int quantidade = cursor.getInt(cursor.getColumnIndex("quantidade"));
                Log.i("Registro: ", id + " " + nome + " " + valor + " " + quantidade);
            }while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
    }


    public void exclui_registro(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete("restaurante", "_id=?", new String[]{id});
        database.close();
    }
    public void exclui_todos_registros(){
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL("DROP TABLE IF EXISTS restaurante");
        database.close();
    }

    /*public List<ItemGerenciar> getGerenciarList(){
        List<ItemGerenciar> gerenciar=new ArrayList<ItemGerenciar>();
        SQLiteDatabase database = this.getReadableDatabase();
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
        }
        return gerenciar;
    }*/
    private int byteArrayToInt (byte[] img){
        return ByteBuffer.wrap(img).getInt();
    }
}