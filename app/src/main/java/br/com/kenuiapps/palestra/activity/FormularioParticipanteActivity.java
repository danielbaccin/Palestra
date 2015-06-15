package br.com.kenuiapps.palestra.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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
    private RadioGroup tamanhoDaBlusa;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_participante);

        nome = (TextView) findViewById(R.id.edit_nome_aluno);
        email = (TextView) findViewById(R.id.edit_email_aluno);
        telefone = (TextView) findViewById(R.id.edit_telefone_aluno);
        tamanhoDaBlusa = (RadioGroup) findViewById(R.id.tamanhoDaBlusa);

        actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setBackgroundDrawable(new ColorDrawable(0xFFFF4500));
            actionBar.setTitle(R.string.titulo_formulario);
        }
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
                                "",
                                email.getText().toString(), 1 ,
                                tamanhoDaBlusa.getCheckedRadioButtonId());
        dao.salva(participante);
        dao.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_form_participante, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
