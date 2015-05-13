package br.com.kenuiapps.palestra.model;

import android.content.ContentValues;

import br.com.kenuiapps.palestra.helper.DataBaseHelper;

/**
 * Created by daniel on 13/05/15.
 */
public class Aluno {

    private Integer id;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private String curso;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.Aluno.ID, getId());
        values.put(DataBaseHelper.Aluno.NOME, getNome());
        values.put(DataBaseHelper.Aluno.TELEFONE, getTelefone());
        values.put(DataBaseHelper.Aluno.ENDERECO, getEndereco());
        values.put(DataBaseHelper.Aluno.EMAIL, getEmail());
        values.put(DataBaseHelper.Aluno.CURSO, getCurso());
        return values;
    }
}
