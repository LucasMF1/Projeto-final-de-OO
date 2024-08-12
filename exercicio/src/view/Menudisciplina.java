package view;

import javax.swing.JOptionPane;

import app.Disciplinas;
import cadastros.CadastroDisciplina;
import exceptions.CampoEmBrancoException;
import exceptions.CancelamentoException;

public class Menudisciplina {
    public static Disciplinas dadosNovaDisciplina() {
        String nome = null, codigoD = null;

        boolean dadosValidos = false;
        while (!dadosValidos) {
            try {
                nome = verificarCampo("Nome", lerNome());
                codigoD = verificarCampo("codigoD", lerCodigoD());
                dadosValidos = true;  // Se todos os campos forem válidos, sai do loop, se não repete tudo 
            } catch (CampoEmBrancoException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (CancelamentoException e) {
                return null;  // Cancela o cadastro
            }
        }

        return new Disciplinas(nome, codigoD);
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

    private static String lerNome() {
        return JOptionPane.showInputDialog("Informe o nome da disciplina: ");
    }

    private static String lerCodigoD() {
        return JOptionPane.showInputDialog("Informe o codigo da disciplina: ");
    }
    

    public static void menuDisciplina(CadastroDisciplina cadDisciplina) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar disciplina\n"
                + "2 - Pesquisar disciplina\n"
                + "3 - Atualizar disciplina\n"
                + "4 - Remover disciplina\n"
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
                        Disciplinas novaDisciplina = dadosNovaDisciplina();
                        if (novaDisciplina != null) {
                            cadDisciplina.cadastrarDisciplina(novaDisciplina);
                        }
                        break;

                    case 2:
                        String codigoD = lerCodigoD();
                        Disciplinas d = cadDisciplina.pesquisarDisciplina(codigoD);
                        if (d != null)
                            JOptionPane.showMessageDialog(null, d.toString());
                        break;

                    case 3:
                        codigoD = lerCodigoD();
                        Disciplinas novoCadastro = dadosNovaDisciplina();
                        if (novoCadastro != null) {
                            boolean atualizado = cadDisciplina.atualizarDisciplinas(codigoD, novoCadastro);
                            if (atualizado) {
                                JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
                            }
                        }
                        break;

                    case 4:
                        codigoD = lerCodigoD();
                        Disciplinas remover = cadDisciplina.pesquisarDisciplina(codigoD);
                        boolean removido = cadDisciplina.removerDisciplina(remover);
                        if (removido) {
                            JOptionPane.showMessageDialog(null, "Disciplina removida do cadastro");
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

