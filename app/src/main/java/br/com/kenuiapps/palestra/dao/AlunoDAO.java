package br.com.kenuiapps.palestra.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.kenuiapps.palestra.helper.DataBaseHelper;
import br.com.kenuiapps.palestra.model.Aluno;

/**
 * Created by daniel on 13/05/15.
 */
public class AlunoDAO extends PalestraDAO{

    private List<Aluno> lista;

    public AlunoDAO(Context context) {
        super(context);
    }
    public long salva(Aluno aluno) {
        ContentValues values = aluno.getContentValues();
        return getDb().insert(DataBaseHelper.Aluno.TABELA, null, values);
    }

    public List<Aluno> getLista() {
        Cursor cursor = getDb().query(DataBaseHelper.Aluno.TABELA, DataBaseHelper.Aluno.COLUNAS, null, null, null, null, null);
        List<Aluno> alunos = new ArrayList<Aluno>();
        while(cursor.moveToNext()){
            Aluno aluno = criarAluno(cursor);
            alunos.add(aluno);
        }
        cursor.close();
        return alunos;
    }


    private Aluno criarAluno(Cursor cursor) {
        Aluno aluno = new Aluno(
                cursor.getString(cursor.getColumnIndex(DataBaseHelper.Aluno.NOME)),
                cursor.getString(cursor.getColumnIndex(DataBaseHelper.Aluno.TELEFONE)),
                cursor.getString(cursor.getColumnIndex(DataBaseHelper.Aluno.ENDERECO)),
                cursor.getString(cursor.getColumnIndex(DataBaseHelper.Aluno.EMAIL)),
                cursor.getString(cursor.getColumnIndex(DataBaseHelper.Aluno.CURSO))
        );
        aluno.setId(cursor.getInt(cursor.getColumnIndex(DataBaseHelper.Aluno.ID)));
        return aluno;
    }
}
