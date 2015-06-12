package br.com.kenuiapps.palestra.activity;

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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.melnykov.fab.FloatingActionButton;

import java.util.List;

import br.com.kenuiapps.palestra.R;
import br.com.kenuiapps.palestra.adapter.ListaParticipantesAdapter;
import br.com.kenuiapps.palestra.dao.ParticipanteDAO;
import br.com.kenuiapps.palestra.model.Participante;


public class ListaParticipantesActivity extends ActionBarActivity implements  AdapterView.OnItemClickListener{

    private AlertDialog alertDialog;
    private int participanteSelecionado;
    private Participante participante;
    private ListView listaDeParticipantes;
    private android.support.v7.app.ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaDeParticipantes = (ListView) findViewById(R.id.listAlunos);
        listaDeParticipantes.setOnItemClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabAddProduto);
        fab.attachToListView(listaDeParticipantes);

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
        ParticipanteDAO dao = new ParticipanteDAO(this);
        List<Participante> participantes =  dao.getLista();
        dao.close();

        ListaParticipantesAdapter listaParticipantesAdapter = new ListaParticipantesAdapter(this, participantes);
        listaDeParticipantes.setAdapter(listaParticipantesAdapter);

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
        startActivity(new Intent(this, FormularioParticipanteActivity.class));
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        listOnItemClick((Participante) parent.getItemAtPosition(position), view);
    }


    private void listOnItemClick(final Participante participante, final View view) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(getString(R.string.dialog_participante_title));
        dialog.setMessage(getString(R.string.confirmacao_presenca));
        dialog.setNegativeButton(R.string.sim, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ImageView imageView = (ImageView)  view.findViewById(R.id.icon_participante);
                imageView.setImageDrawable(ListaParticipantesActivity.this.getResources().getDrawable(R.drawable.ic_done_black_24dp));
                Toast.makeText(ListaParticipantesActivity.this, "Presença confirmada", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setPositiveButton(R.string.nao, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ImageView imageView = (ImageView)  view.findViewById(R.id.icon_participante);
                imageView.setImageDrawable(ListaParticipantesActivity.this.getResources().getDrawable(R.drawable.ic_action_accept));
                Toast.makeText(ListaParticipantesActivity.this, "Ausencia confirmada", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }

}
