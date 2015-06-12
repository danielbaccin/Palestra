package br.com.kenuiapps.palestra;

import android.test.AndroidTestCase;

import br.com.kenuiapps.palestra.dao.ParticipanteDAO;
import br.com.kenuiapps.palestra.model.Participante;

/**
 * Created by daniel on 13/05/15.
 */
public class ParticipanteDAOTest extends AndroidTestCase {

    public void testInsertDb()
    {
        ParticipanteDAO dao = new ParticipanteDAO(mContext);
        long qtdDeLinhasInseridas = dao.salva(dadoUmAluno());
        assertTrue(qtdDeLinhasInseridas>0);
    }

    private Participante dadoUmAluno() {
        Participante participante = new Participante();
        participante.setNome("Participante teste");
        participante.setTelefone("8888888888");
        participante.setEndereco("AV teste 2312");
        participante.setEmail("participante@javace.com.br");
        return participante;
    }


}
