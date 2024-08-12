package view;

import javax.swing.JOptionPane;
import app.Aluno;
import app.Turma;
import cadastros.CadastroTurma;
import exceptions.CampoEmBrancoException;
import exceptions.CancelamentoException;

public class MenuTurma {

    public static Turma dadosNovaTurma() {
        String codigoTurma = null, disciplina = null, professor = null;

        boolean dadosValidos = false;
        while (!dadosValidos) {
            try {
                codigoTurma = verificarCampo("Código da Turma", lerCodigoTurma());
                disciplina = verificarCampo("Disciplina", lerDisciplina());
                professor = verificarCampo("Professor", lerProfessor());
                dadosValidos = true;
            } catch (CampoEmBrancoException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (CancelamentoException e) {
                return null;
            }
        }

        return new Turma(codigoTurma, disciplina, professor);
    }

    public static Aluno dadosNovoAluno() {
        String nomeAluno = null, matriculaA = null;

        boolean dadosValidos = false;
        while (!dadosValidos) {
            try {
                nomeAluno = verificarCampo("Nome do Aluno", lerNome());
                matriculaA = verificarCampo("Matrícula do Aluno", lerMatriculaA());
                dadosValidos = true;
            } catch (CampoEmBrancoException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (CancelamentoException e) {
                return null;
            }
        }

        return new Aluno(nomeAluno, matriculaA, matriculaA, matriculaA, matriculaA);
    }

    private static String verificarCampo(String campo, String valor) throws CampoEmBrancoException, CancelamentoException {
        if (valor == null) {
            throw new CancelamentoException("Cadastro cancelado.");
        }
        if (valor.trim().isEmpty()) {
            throw new CampoEmBrancoException(campo);
        }
        return valor;
    }

    private static String lerCodigoTurma() {
        return JOptionPane.showInputDialog("Informe o código da turma: ");
    }

    private static String lerDisciplina() {
        return JOptionPane.showInputDialog("Informe a disciplina: ");
    }

    private static String lerProfessor() {
        return JOptionPane.showInputDialog("Informe o professor: ");
    }

    private static String lerNome() {
        return JOptionPane.showInputDialog("Informe o nome do aluno: ");
    }

    private static String lerMatriculaA() {
        return JOptionPane.showInputDialog("Informe a matrícula do aluno: ");
    }

    public static void menuTurma(CadastroTurma cadTurma) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar turma\n"
                + "2 - Pesquisar turma\n"
                + "3 - Atualizar turma\n"
                + "4 - Remover turma\n"
                + "5 - Adicionar aluno\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            try {
                String strOpcao = JOptionPane.showInputDialog(txt);
                if (strOpcao == null) {
                    opcao = 0;  // cancelar ou fechar
                } else {
                    opcao = Integer.parseInt(strOpcao);
                }

                switch (opcao) {
                    case 1:
                        Turma novaTurma = dadosNovaTurma();
                        if (novaTurma != null) {
                            cadTurma.cadastrarTurma(novaTurma);
                        }
                        break;

                    case 2:
                        String codigoTurma = lerCodigoTurma();
                        Turma t = cadTurma.pesquisarTurma(codigoTurma);
                        if (t != null) {
                            JOptionPane.showMessageDialog(null, t.toString());
                        }
                        break;

                    case 3:
                        codigoTurma = lerCodigoTurma();
                        Turma novoCadastro = dadosNovaTurma();
                        if (novoCadastro != null) {
                            boolean atualizado = cadTurma.atualizarTurma(codigoTurma, novoCadastro);
                            if (atualizado) {
                                JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
                            }
                        }
                        break;

                    case 4:
                        codigoTurma = lerCodigoTurma();
                        Turma remover = cadTurma.pesquisarTurma(codigoTurma);
                        boolean removido = cadTurma.removerTurma(remover);
                        if (removido) {
                            JOptionPane.showMessageDialog(null, "Turma removida do cadastro");
                        }
                        break;
                        
                    case 5:
                        Aluno novoAluno = dadosNovoAluno();
                        codigoTurma = lerCodigoTurma();
                        if (novoAluno != null) {
                            boolean adicionado = cadTurma.addAluno(novoAluno, codigoTurma);
                            if (adicionado) {
                                JOptionPane.showMessageDialog(null, "Aluno adicionado.");
                            }
                        }
                        break;

                    default:
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número.");
            }
        } while (opcao != 0);
    }
}