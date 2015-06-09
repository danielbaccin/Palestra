package br.com.kenuiapps.palestra.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.melnykov.fab.FloatingActionButton;

import java.util.List;

import br.com.kenuiapps.palestra.R;
import br.com.kenuiapps.palestra.adapter.ListaAlunosAdapter;
import br.com.kenuiapps.palestra.dao.AlunoDAO;
import br.com.kenuiapps.palestra.model.Aluno;


public class ListaAlunosActivity extends ActionBarActivity {

    private ListView listaDeAlunos;
    private android.support.v7.app.ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaDeAlunos = (ListView) findViewById(R.id.listAlunos);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabAddProduto);
        fab.attachToListView(listaDeAlunos);

         actionBar = getSupportActionBar();

        if(actionBar!=null)
            actionBar.setBackgroundDrawable(new ColorDrawable(0xFFFF4500));

    }


    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main , menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void carregaLista() {
        AlunoDAO dao = new AlunoDAO(this);
        List<Aluno> alunos =  dao.getLista();
        dao.close();

        ListaAlunosAdapter listaAlunosAdapter = new ListaAlunosAdapter(this, alunos);
        listaDeAlunos.setAdapter(listaAlunosAdapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_sincronizar) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void abrirFormAluno(View view){
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }
}
