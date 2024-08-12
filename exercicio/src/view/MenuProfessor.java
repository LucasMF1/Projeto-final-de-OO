package view;

import javax.swing.JOptionPane;
import app.Professor;
import cadastros.CadastroProfessor;
import exceptions.CampoEmBrancoException;
import exceptions.CancelamentoException;

public class MenuProfessor {

	public static Professor dadosNovoProfessor(){
		String nome = null, cpf = null, email = null, matriculaFUB = null, AreaFormacao = null;

        boolean dadosValidos = false;
        while (!dadosValidos) {
            try {
                nome = verificarCampo("Nome", lerNome());
                cpf = verificarCampo("CPF", lerCPF());
                email = verificarCampo("Email", lerEmail());
                matriculaFUB = verificarCampo("Matrícula", lerMatriculaFUB());
                AreaFormacao = verificarCampo("Area Formacao", lerAreaFormacao());
                dadosValidos = true;  // Tudo ok, faz sair 
            } catch (CampoEmBrancoException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (CancelamentoException e) {
                return null;  // Cancela o cadastro
            }
        }
        
        return new Professor(nome, cpf, email, matriculaFUB, AreaFormacao);
	}
	private static String verificarCampo(String i, String vi) throws CampoEmBrancoException, CancelamentoException {
		if (vi == null) {
            throw new CancelamentoException("Cadastro cancelado.");
        }
        if (vi.trim().isEmpty()) {
            throw new CampoEmBrancoException(i);
        }
        return vi;
    }

	private static String lerAreaFormacao() {
		return JOptionPane.showInputDialog("Informe o area de formação do professor: ");
	}

	private static String lerEmail() {
		return JOptionPane.showInputDialog("Informe o email do professor: ");
	}

	private static String lerCPF() {
		return JOptionPane.showInputDialog("Informe o CPF do professor: ");
	}

	private static String lerNome() {
		return JOptionPane.showInputDialog("Informe o nome do professor: ");
	}

	private static String lerMatriculaFUB() {
		return JOptionPane.showInputDialog("Informe a matriculaFUB do professor: ");
	}

	public static void menuProfessor(CadastroProfessor cadProfessor) {
		String txt = "Informe a opção desejada \n"
				+ "1 - Cadastrar professor\n"
				+ "2 - Pesquisar professor\n"
				+ "3 - Atualizar professor\n"
				+ "4 - Remover professor\n"
				+ "0 - Voltar para menu anterior";
		
		int opcao=-1;
		do {
			String strOpcao = JOptionPane.showInputDialog(txt);
			opcao = Integer.parseInt(strOpcao);

			switch (opcao) {
			case 1:
				Professor novoProfessor = dadosNovoProfessor();
				cadProfessor.cadastrarProfessor(novoProfessor);
				break;
				
			case 2: 
				String matriculaFUB = lerMatriculaFUB();
				Professor p = cadProfessor.pesquisarProfessor(matriculaFUB);
				if (p != null)
					JOptionPane.showMessageDialog(null, p.toString());
				break;
				
			case 3: 
				matriculaFUB = lerMatriculaFUB(); 
				Professor novoCadastro = dadosNovoProfessor();
				boolean atualizado = cadProfessor.atualizarProfessor(matriculaFUB, novoCadastro);
				if (atualizado) {
					JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
				}
				break;
				
			case 4: 
				matriculaFUB = lerMatriculaFUB();
				Professor remover = cadProfessor.pesquisarProfessor(matriculaFUB);
				boolean removido = cadProfessor.removerProfessor(remover);
				if (removido) {
					JOptionPane.showMessageDialog(null, "Professor removido do cadastro");
					System.gc();
				}

			default:
				break;
			}
		} while (opcao != 0);
		return;
	}
	}
