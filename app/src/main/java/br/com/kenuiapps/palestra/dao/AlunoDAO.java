package br.com.kenuiapps.palestra.dao;

import android.content.ContentValues;
import android.content.Context;

import br.com.kenuiapps.palestra.helper.DataBaseHelper;
import br.com.kenuiapps.palestra.model.Aluno;

/**
 * Created by daniel on 13/05/15.
 */
public class AlunoDAO extends PalestraDAO{

    public AlunoDAO(Context context) {
        super(context);
    }
    public long salva(Aluno aluno) {
        ContentValues values = aluno.getContentValues();
        return getDb().insert(DataBaseHelper.Aluno.TABELA, null, values);
    }

}
