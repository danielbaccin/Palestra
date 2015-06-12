package br.com.kenuiapps.palestra.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.kenuiapps.palestra.R;
import br.com.kenuiapps.palestra.model.Participante;

/**
 * Created by daniel on 14/05/15.
 */
public class ListaParticipantesAdapter extends BaseAdapter {

    private Activity activity;
    private List<Participante> participantes;

    public ListaParticipantesAdapter(Activity activity, List<Participante> participantes) {
        this.activity = activity;
        this.participantes = participantes;
    }

    @Override
    public int getCount() {
        return participantes.size();
    }

    @Override
    public Object getItem(int position) {
        return participantes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return participantes.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View linha = activity.getLayoutInflater().inflate(R.layout.lista_participantes, null);

        Participante participante = participantes.get(position);

        TextView nome = (TextView) linha.findViewById(R.id.lista_aluno_nome);
        nome.setText(participante.getNome());

        ImageView iconeDePresenca = (ImageView) linha.findViewById(R.id.icon_participante);
        if(participante.getPresente().equals(1)){
            iconeDePresenca.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_done_black_24dp));
        }else{
            iconeDePresenca.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_action_accept));
        }

        return linha;
    }
}
