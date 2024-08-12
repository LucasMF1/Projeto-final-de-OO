package view;

import javax.swing.JOptionPane;
import app.Aluno;
import cadastros.CadastroAluno;
import exceptions.CampoEmBrancoException;
import exceptions.CancelamentoException;

public class MenuAluno {

    public static Aluno dadosNovoAluno() {
        String nome = null, cpf = null, email = null, matricula = null, curso = null;

        boolean dadosValidos = false;
        while (!dadosValidos) {
            try {
                nome = verificarCampo("Nome", lerNome());
                cpf = verificarCampo("CPF", lerCPF());
                email = verificarCampo("Email", lerEmail());
                matricula = verificarCampo("Matrícula", lerMatricula());
                curso = verificarCampo("Curso", lerCurso());
                dadosValidos = true;  // Se todos os campos forem válidos, sai do loop, se não repete tudo 
            } catch (CampoEmBrancoException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (CancelamentoException e) {
                return null;  // Cancela o cadastro
            }
        }

        return new Aluno(nome, cpf, email, matricula, curso);
    }
    //verifica se a pessoa apertou no cancelar ou tentou fechar e se tem algum campo em branco(i= ao campo, vi = valor do campo(1,0))
    private static String verificarCampo(String i, String vi) throws CampoEmBrancoException, CancelamentoException {
        if (vi == null) {
            throw new CancelamentoException("Cadastro cancelado.");
        }
        if (vi.trim().isEmpty()) {
            throw new CampoEmBrancoException(i);
        }
        return vi;
    }

    private static String lerCurso() {
        return JOptionPane.showInputDialog("Informe o curso do aluno: ");
    }

    private static String lerEmail() {
        return JOptionPane.showInputDialog("Informe o email do aluno: ");
    }

    private static String lerCPF() {
        return JOptionPane.showInputDialog("Informe o CPF do aluno: ");
    }

    private static String lerNome() {
        return JOptionPane.showInputDialog("Informe o nome do aluno: ");
    }

    private static String lerMatricula() {
        return JOptionPane.showInputDialog("Informe a matrícula do aluno: ");
    }

    public static void menuAluno(CadastroAluno cadAluno) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar aluno\n"
                + "2 - Pesquisar aluno\n"
                + "3 - Atualizar aluno\n"
                + "4 - Remover aluno\n"
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
                        Aluno novoAluno = dadosNovoAluno();
                        if (novoAluno != null) {
                            cadAluno.cadastrarAluno(novoAluno);
                        }
                        break;

                    case 2:
                        String matricula = lerMatricula();
                        Aluno a = cadAluno.pesquisarAluno(matricula);
                        if (a != null)
                            JOptionPane.showMessageDialog(null, a.toString());
                        break;

                    case 3:
                        matricula = lerMatricula();
                        Aluno novoCadastro = dadosNovoAluno();
                        if (novoCadastro != null) {
                            boolean atualizado = cadAluno.atualizarAluno(matricula, novoCadastro);
                            if (atualizado) {
                                JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
                            }
                        }
                        break;

                    case 4:
                        matricula = lerMatricula();
                        Aluno remover = cadAluno.pesquisarAluno(matricula);
                        boolean removido = cadAluno.removerAluno(remover);
                        if (removido) {
                            JOptionPane.showMessageDialog(null, "Aluno removido do cadastro");
                            System.gc();
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
