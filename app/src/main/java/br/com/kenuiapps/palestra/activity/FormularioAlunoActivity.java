package br.com.kenuiapps.palestra.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.TextView;

import br.com.kenuiapps.palestra.R;
import br.com.kenuiapps.palestra.dao.AlunoDAO;
import br.com.kenuiapps.palestra.helper.DataBaseHelper;
import br.com.kenuiapps.palestra.model.Aluno;

/**
 * Created by daniel on 13/05/15.
 */
public class FormularioAlunoActivity extends ActionBarActivity{

    private TextView nome;
    private TextView endereco;
    private TextView email;
    private TextView telefone;
    private Spinner curso;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_aluno);

        nome = (TextView) findViewById(R.id.edit_nome_aluno);
        endereco = (TextView) findViewById(R.id.edit_endereco_aluno);
        email = (TextView) findViewById(R.id.edit_email_aluno);
        telefone = (TextView) findViewById(R.id.edit_telefone_aluno);
        curso = (Spinner) findViewById(R.id.spinner_cursos);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_salvar:
                salvarAluno();
                startActivity(new Intent(this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    private void salvarAluno() {
        AlunoDAO dao = new AlunoDAO(this);

        Aluno aluno = new Aluno(nome.getText().toString(),
                                telefone.getText().toString(),
                                endereco.getText().toString(),
                                email.getText().toString(),
                                "");//curso.getSelectedItem().toString());
        dao.salva(aluno);
        dao.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_form_aluno, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
