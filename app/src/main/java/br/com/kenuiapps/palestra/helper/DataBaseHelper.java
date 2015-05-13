package br.com.kenuiapps.palestra.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by daniel on 13/05/15.
 */
public class DataBaseHelper extends SQLiteOpenHelper {


    public static final String BANCO_DADOS = "Palestra";
    private static int VERSAO = 1;

    public DataBaseHelper(Context context) {
        super(context, BANCO_DADOS, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE aluno"+
                    " (_id INTEGER PRIMARY KEY," +
                    " nome TEXT," +
                    " telefone TEXT," +
                    " endereco TEXT," +
                    " email TEXT," +
                    " curso TEXT);"
                  );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }


    public static class Aluno {
        public static final String TABELA = "aluno";
        public static final String ID = "_id";
        public static final String NOME = "nome";
        public static final String TELEFONE = "telefone";
        public static final String ENDERECO = "endereco";
        public static final String EMAIL = "email";
        public static final String CURSO = "curso";
        public static final String[] COLUNAS = new String[]{ID, NOME, TELEFONE, ENDERECO, EMAIL, CURSO};
    }

}

