package exceptions;

public class ProfessorNaoAtribuidoException extends Exception{
    public ProfessorNaoAtribuidoException() {
        super("A turma não pode ser cadastrada sem um professor atribuído");
    }
}