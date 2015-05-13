package br.com.kenuiapps.palestra.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import br.com.kenuiapps.palestra.helper.DataBaseHelper;

/**
 * Created by daniel on 13/05/15.
 */
public class PalestraDAO {

    private DataBaseHelper helper;
    private SQLiteDatabase db;

    public PalestraDAO(Context context){
        helper = new DataBaseHelper(context);
    }

    public SQLiteDatabase getDb() {
        if (db == null) {
            db = helper.getWritableDatabase();
        }
        return db;
    }

    public void close(){
        helper.close();
    }

}
