package br.com.kenuiapps.palestra;

import android.test.AndroidTestCase;

import br.com.kenuiapps.palestra.dao.AlunoDAO;
import br.com.kenuiapps.palestra.model.Aluno;

/**
 * Created by daniel on 13/05/15.
 */
public class AlunoDAOTest  extends AndroidTestCase {

    public void testInsertDb()
    {
        AlunoDAO dao = new AlunoDAO(mContext);
        long qtdDeLinhasInseridas = dao.salva(dadoUmAluno());
        assertTrue(qtdDeLinhasInseridas>0);
    }

    private Aluno dadoUmAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome("Aluno teste");
        aluno.setTelefone("8888888888");
        aluno.setEndereco("AV teste 2312");
        aluno.setEmail("aluno@javace.com.br");
        aluno.setCurso("curso");
        return aluno;
    }


}
