package app;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codigoTurma;
    private String disciplina;
    private String professor;
    private List<Aluno> alunos;

    public Turma(String codigoTurma, String disciplina, String professor) {
        this.codigoTurma = codigoTurma;
        this.disciplina = disciplina;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }

    public Turma(String nomeAluno, String matriculaA) {
        // Construtor para adicionar aluno
        this.alunos = new ArrayList<>();
        // Inicializa com dados fictícios ou defaults para o exemplo
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Código da Turma: ").append(codigoTurma).append("\n");
        sb.append("Disciplina: ").append(disciplina).append("\n");
        sb.append("Professor: ").append(professor).append("\n");
        sb.append("Alunos:\n");
        for (Aluno aluno : alunos) {
            sb.append("Nome: ").append(aluno.getNome()).append(", Matrícula: ").append(aluno.getMatricula()).append("\n");
        }
        return sb.toString();
    }
}