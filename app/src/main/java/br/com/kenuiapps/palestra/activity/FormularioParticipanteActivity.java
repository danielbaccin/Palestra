package br.com.kenuiapps.palestra.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.TextView;

import br.com.kenuiapps.palestra.R;
import br.com.kenuiapps.palestra.dao.ParticipanteDAO;
import br.com.kenuiapps.palestra.model.Participante;

/**
 * Created by daniel on 13/05/15.
 */
public class FormularioParticipanteActivity extends ActionBarActivity{

    private TextView nome;
    private TextView endereco;
    private TextView email;
    private TextView telefone;
    private android.support.v7.app.ActionBar actionBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_aluno);

        nome = (TextView) findViewById(R.id.edit_nome_aluno);
        endereco = (TextView) findViewById(R.id.edit_endereco_aluno);
        email = (TextView) findViewById(R.id.edit_email_aluno);
        telefone = (TextView) findViewById(R.id.edit_telefone_aluno);

        actionBar = getSupportActionBar();

        if(actionBar!=null)
            actionBar.setBackgroundDrawable(new ColorDrawable(0xFFFF4500));


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_salvar:
                salvarAluno();
                startActivity(new Intent(this, ListaParticipantesActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    private void salvarAluno() {
        ParticipanteDAO dao = new ParticipanteDAO(this);

        Participante participante = new Participante(nome.getText().toString(),
                                telefone.getText().toString(),
                                endereco.getText().toString(),
                                email.getText().toString(), 1 );
        dao.salva(participante);
        dao.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_form_aluno, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
