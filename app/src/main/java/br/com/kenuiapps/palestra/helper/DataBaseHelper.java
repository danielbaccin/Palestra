package br.com.kenuiapps.palestra.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by daniel on 13/05/15.
 */
public class DataBaseHelper extends SQLiteOpenHelper {


    public static final String BANCO_DADOS = "Palestra";
    private static int VERSAO = 2;

    public DataBaseHelper(Context context) {
        super(context, BANCO_DADOS, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE participante"+
                    " ( " +
                        " _id INTEGER PRIMARY KEY," +
                        " nome TEXT," +
                        " telefone TEXT," +
                        " endereco TEXT," +
                        " email TEXT," +
                        " presente INTEGER, " +
                        " tamanhoBlusa INTEGER" +
                    " );"
                  );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dll = "DROP TABLE IF EXISTS participante";
        db.execSQL(dll);
        this.onCreate(db);
    }


    public static class Participante {
        public static final String TABELA = "participante";
        public static final String ID = "_id";
        public static final String NOME = "nome";
        public static final String TELEFONE = "telefone";
        public static final String ENDERECO = "endereco";
        public static final String EMAIL = "email";
        public static final String PRESENTE = "presente";
        public static final String TAMANHO_BLUSA = "tamanhoBlusa";
        public static final String[] COLUNAS = new String[]{ID, NOME, TELEFONE, ENDERECO, EMAIL, PRESENTE, TAMANHO_BLUSA};
    }

}

