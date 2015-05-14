package br.com.kenuiapps.palestra.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.kenuiapps.palestra.R;
import br.com.kenuiapps.palestra.model.Aluno;

/**
 * Created by daniel on 14/05/15.
 */
public class ListaAlunosAdapter extends BaseAdapter {

    private Activity activity;
    private List<Aluno> alunos;

    public ListaAlunosAdapter(Activity activity, List<Aluno> alunos) {
        this.activity = activity;
        this.alunos = alunos;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return alunos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View linha = activity.getLayoutInflater().inflate(R.layout.lista_alunos, null);

        Aluno aluno  = alunos.get(position);

        TextView nome = (TextView) linha.findViewById(R.id.lista_aluno_nome);
        nome.setText(aluno.getNome());
        return linha;
    }
}
