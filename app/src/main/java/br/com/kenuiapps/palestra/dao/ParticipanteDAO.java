package br.com.kenuiapps.palestra.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.kenuiapps.palestra.helper.DataBaseHelper;

/**
 * Created by daniel on 13/05/15.
 */
public class ParticipanteDAO extends PalestraDAO{

    private List<br.com.kenuiapps.palestra.model.Participante> lista;

    public ParticipanteDAO(Context context) {
        super(context);
    }
    public long salva(br.com.kenuiapps.palestra.model.Participante participante) {
        ContentValues values = participante.getContentValues();
        return getDb().insert(DataBaseHelper.Participante.TABELA, null, values);
    }

    public List<br.com.kenuiapps.palestra.model.Participante> getLista() {
        Cursor cursor = getDb().query(DataBaseHelper.Participante.TABELA, DataBaseHelper.Participante.COLUNAS, null, null, null, null, null);
        List<br.com.kenuiapps.palestra.model.Participante> participantes = new ArrayList<br.com.kenuiapps.palestra.model.Participante>();
        while(cursor.moveToNext()){
            br.com.kenuiapps.palestra.model.Participante participante = criarAluno(cursor);
            participantes.add(participante);
        }
        cursor.close();
        return participantes;
    }


    private br.com.kenuiapps.palestra.model.Participante criarAluno(Cursor cursor) {
        br.com.kenuiapps.palestra.model.Participante participante = new br.com.kenuiapps.palestra.model.Participante(
                cursor.getString(cursor.getColumnIndex(DataBaseHelper.Participante.NOME)),
                cursor.getString(cursor.getColumnIndex(DataBaseHelper.Participante.TELEFONE)),
                cursor.getString(cursor.getColumnIndex(DataBaseHelper.Participante.ENDERECO)),
                cursor.getString(cursor.getColumnIndex(DataBaseHelper.Participante.EMAIL)),
                cursor.getInt(cursor.getColumnIndex(DataBaseHelper.Participante.PRESENTE))
        );
        participante.setId(cursor.getInt(cursor.getColumnIndex(DataBaseHelper.Participante.ID)));
        return participante;
    }
}
