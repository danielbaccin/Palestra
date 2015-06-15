package br.com.kenuiapps.palestra.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.kenuiapps.palestra.helper.DataBaseHelper;
import br.com.kenuiapps.palestra.model.Participante;

/**
 * Created by daniel on 13/05/15.
 */
public class ParticipanteDAO extends PalestraDAO{

    private List<Participante> lista;

    public ParticipanteDAO(Context context) {
        super(context);
    }
    public long salva(br.com.kenuiapps.palestra.model.Participante participante) {
        ContentValues values = participante.getContentValues();
        return getDb().insert(DataBaseHelper.Participante.TABELA, null, values);
    }

    public List<Participante> getLista() {
        Cursor cursor = getDb().query(DataBaseHelper.Participante.TABELA, DataBaseHelper.Participante.COLUNAS, null, null, null, null, null);
        List<br.com.kenuiapps.palestra.model.Participante> participantes = new ArrayList<br.com.kenuiapps.palestra.model.Participante>();
        while(cursor.moveToNext()){
            br.com.kenuiapps.palestra.model.Participante participante = criarParticipante(cursor);
            participantes.add(participante);
        }
        cursor.close();
        return participantes;
    }


    private Participante criarParticipante(Cursor cursor) {
        br.com.kenuiapps.palestra.model.Participante participante = new br.com.kenuiapps.palestra.model.Participante(
                cursor.getString(cursor.getColumnIndex(DataBaseHelper.Participante.NOME)),
                cursor.getString(cursor.getColumnIndex(DataBaseHelper.Participante.TELEFONE)),
                cursor.getString(cursor.getColumnIndex(DataBaseHelper.Participante.ENDERECO)),
                cursor.getString(cursor.getColumnIndex(DataBaseHelper.Participante.EMAIL)),
                cursor.getInt(cursor.getColumnIndex(DataBaseHelper.Participante.PRESENTE)),
                cursor.getInt(cursor.getColumnIndex(DataBaseHelper.Participante.TAMANHO_BLUSA))
        );
        participante.setId(cursor.getInt(cursor.getColumnIndex(DataBaseHelper.Participante.ID)));
        return participante;
    }

    public boolean atualizaPresencaPorId(Integer idParticipante, int flagDePresenca) {
        String[] args = {idParticipante.toString()};
        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.Participante.PRESENTE, flagDePresenca);
        int atualizou = getDb().update(DataBaseHelper.Participante.TABELA, values, DataBaseHelper.Participante.ID + " = ?", args);
        return  atualizou == 1;
    }
}
