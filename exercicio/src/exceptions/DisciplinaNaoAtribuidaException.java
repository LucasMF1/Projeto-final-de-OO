package exceptions;

public class DisciplinaNaoAtribuidaException extends Exception{
    public DisciplinaNaoAtribuidaException() {
        super("A turma não pode ser cadastrada sem uma disciplina atribuída");
    }
}