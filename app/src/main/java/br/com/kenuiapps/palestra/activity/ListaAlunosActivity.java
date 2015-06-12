package br.com.kenuiapps.palestra.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.melnykov.fab.FloatingActionButton;

import java.util.List;

import br.com.kenuiapps.palestra.R;
import br.com.kenuiapps.palestra.adapter.ListaAlunosAdapter;
import br.com.kenuiapps.palestra.dao.AlunoDAO;
import br.com.kenuiapps.palestra.model.Aluno;


public class ListaAlunosActivity extends ActionBarActivity implements  AdapterView.OnItemClickListener{

    private AlertDialog alertDialog;
    private int alunoSelecionado;
    private Aluno aluno;
    private ListView listaDeAlunos;
    private android.support.v7.app.ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaDeAlunos = (ListView) findViewById(R.id.listAlunos);
        listaDeAlunos.setOnItemClickListener(this);

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
        if (id == R.id.action_receber_lista) {
            //fazer algo
            return true;

        }
        return super.onOptionsItemSelected(item);
    }

    public void abrirFormAluno(View view){
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        listOnItemClick((Aluno) parent.getItemAtPosition(position), view);
    }


    private void listOnItemClick(final Aluno aluno, final View view) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(getString(R.string.dialog_participante_title));
        dialog.setMessage(getString(R.string.confirmacao_presenca));
        dialog.setNegativeButton(R.string.sim, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ImageView imageView = (ImageView)  view.findViewById(R.id.icon_participante);
                imageView.setImageDrawable(ListaAlunosActivity.this.getResources().getDrawable(R.drawable.ic_done_black_24dp));
                Toast.makeText(ListaAlunosActivity.this, "Presença confirmada", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setPositiveButton(R.string.nao, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ImageView imageView = (ImageView)  view.findViewById(R.id.icon_participante);
                imageView.setImageDrawable(ListaAlunosActivity.this.getResources().getDrawable(R.drawable.ic_action_accept));
                Toast.makeText(ListaAlunosActivity.this, "Ausencia confirmada", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }

}
