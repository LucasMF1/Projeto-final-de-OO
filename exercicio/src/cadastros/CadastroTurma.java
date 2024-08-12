package cadastros;

import app.Aluno;
import app.Turma;

public class CadastroTurma {
    private int numTurmas;
    private Turma[] turmas;

    public CadastroTurma() {
        numTurmas = 0;
        turmas = new Turma[0];
    }

    public int cadastrarTurma(Turma t) {
        Turma[] temp = new Turma[numTurmas + 1];
        for (int i = 0; i < turmas.length; i++) {
            temp[i] = turmas[i];
        }
        temp[temp.length - 1] = t;
        turmas = temp;
        numTurmas++;
        return numTurmas;
    }

    public Turma pesquisarTurma(String codigoTurma) {
        for (Turma t : turmas) {
            if (t.getCodigoTurma().equalsIgnoreCase(codigoTurma)) {
                return t;
            }
        }
        return null;
    }

    public boolean removerTurma(Turma t) {
        Turma remover = pesquisarTurma(t.getCodigoTurma());
        if (remover == null) {
            return false;
        }

        Turma[] temp = new Turma[numTurmas - 1];
        int j = 0;
        for (Turma turma : turmas) {
            if (!turma.equals(remover)) {
                temp[j] = turma;
                j++;
            }
        }
        turmas = temp;
        numTurmas--;
        return true;
    }

    public boolean atualizarTurma(String codigoTurma, Turma t) {
        for (int i = 0; i < turmas.length; i++) {
            if (turmas[i].getCodigoTurma().equalsIgnoreCase(codigoTurma)) {
                turmas[i] = t;
                return true;
            }
        }
        return false;
    }

    public boolean addAluno(Aluno aluno, String codigoTurma) {
        Turma turma = pesquisarTurma(codigoTurma);
        if (turma != null) {
            turma.addAluno(aluno);
            return true;
        }
        return false;
    }
}