package br.com.kenuiapps.palestra.model;

import android.content.ContentValues;

import br.com.kenuiapps.palestra.helper.DataBaseHelper;

/**
 * Created by daniel on 13/05/15.
 */
public class Participante {

    private Integer id;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private Integer presente;

    public Participante(){}

    public Participante(String nome, String telefone, String endereco, String email, Integer presente) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.presente = presente;
    }

    public Integer getPresente() {
        return presente;
    }

    public void setPresente(Integer presente) {
        this.presente = presente;
    }

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

    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.Participante.ID, getId());
        values.put(DataBaseHelper.Participante.NOME, getNome());
        values.put(DataBaseHelper.Participante.TELEFONE, getTelefone());
        values.put(DataBaseHelper.Participante.ENDERECO, getEndereco());
        values.put(DataBaseHelper.Participante.EMAIL, getEmail());
        values.put(DataBaseHelper.Participante.PRESENTE, getPresente());
        return values;
    }
}
