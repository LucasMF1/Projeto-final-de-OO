package app;
import javax.swing.JOptionPane;

import cadastros.CadastroAluno;
import view.MenuAluno;

import view.MenuPrincipal;

import cadastros.CadastroDisciplina;
import view.Menudisciplina;

import cadastros.CadastroProfessor;
import view.MenuProfessor;

import cadastros.CadastroTurma;
import view.MenuTurma;


public class Principal {

	static CadastroAluno cadAluno;
	static CadastroProfessor cadProfessor;
	static CadastroDisciplina cadDisciplina;
	static CadastroTurma cadTurma;
	
	
	public static void main(String[] args) {
		cadAluno = new CadastroAluno();
		cadProfessor = new CadastroProfessor();
		cadDisciplina = new CadastroDisciplina();
		cadTurma = new CadastroTurma();
		
		int opcao = 0; 
		
		do {
			opcao = MenuPrincipal.menuOpcoes(); 
			switch (opcao) {
				case 1: 
					MenuAluno.menuAluno(cadAluno); 
				break;
				case 2: 
					MenuProfessor.menuProfessor(cadProfessor); 
				break;
				case 3: 
					Menudisciplina.menuDisciplina(cadDisciplina);
				break;
				case 4: 
					MenuTurma.menuTurma(cadTurma);
				break;
				case 0: 
				break;
				default: 
					JOptionPane.showMessageDialog(null, "Opcao invalida");
					opcao = -1;
				break;
			}
		} while (opcao != 0);
		return;
	}


}