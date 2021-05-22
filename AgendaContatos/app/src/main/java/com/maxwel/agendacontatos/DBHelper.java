package com.maxwel.agendacontatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    public final static String NOME_BANCO = "BANCO_AGENDA";
    public final static int VERSAO_BANCO = 1;

    public DBHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE agenda (_id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, telefone TEXT);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS agenda");
        onCreate(db);
    }

    public void insere_registro(String nome,String telefone){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues valores_para_inserir_no_banco = new ContentValues();
        valores_para_inserir_no_banco.put("nome", nome);
        valores_para_inserir_no_banco.put("telefone", telefone);

        database.insert("agenda", null, valores_para_inserir_no_banco);

        database.close();
    }

    public void atualiza_registro(String id, String nome,String telefone){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put("_id",id);
        content.put("nome",nome);
        content.put("telefone",telefone);

        database.update("agenda", content, "_id=?", new String[]{id});

        database.close();
    }

    public  void  recupera_todos_registros(){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query("agenda", new String[] {"_id","nome","telefone"},
                null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                String id = cursor.getString(cursor.getColumnIndex("_id"));
                String nome = cursor.getString(cursor.getColumnIndex("nome"));
                String telefone = cursor.getString(cursor.getColumnIndex("telefone"));
                Log.i("Registro: ", id + " " + nome + " " + telefone);
            }while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
    }

    public void exclui_registro(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete("agenda", "_id=?", new String[]{id});
        database.close();
    }
}
