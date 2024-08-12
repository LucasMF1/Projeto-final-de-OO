package cadastros;



import app.Professor;

public class CadastroProfessor {
	int numProfessores;
	private Professor[] professores;
	
	public CadastroProfessor() {
		numProfessores = 0;
		professores = new Professor[0];
	}
	public int cadastrarProfessor(Professor p) {
		Professor[] temp = new Professor[numProfessores + 1];
		for(int i = 0; i < professores.length; i++) {
			temp[i] = professores[i];
		}
		temp[temp.length - 1] = p;
		professores = temp;
		numProfessores ++;
		return numProfessores;
	}
	public Professor pesquisarProfessor(String	matriculaFUB) {
		Professor resposta = null;
		for(int i =0; i<professores.length; i++) {
			Professor p = professores[i];
			String mat = p.getMatriculaFUB();
			if(mat.equalsIgnoreCase(matriculaFUB)) {
				return professores[i];
			}
		}
		return resposta;
	}
	public boolean removerProfessor(Professor p) {
		Professor remover = null;
		if(p != null) {
			remover = pesquisarProfessor(p.getMatriculaFUB());
		}
		if(remover == null) {
			return false;
		}
		Professor[] temp = new Professor[numProfessores - 1];
		int j=0;
		for(int i = 0; i<numProfessores; i++) {
			if(professores[i] != remover) {
				temp[j] = professores[i];
				j++;
			}
			else {
				professores[i] = null;
			}
		}
		professores = temp;
		numProfessores --;
		return true;
	}
	public boolean atualizarProfessor(String matriculaFUB, Professor p) {
		int i;
		for(i=0; i<11; i++) {
			if(professores[i].getMatriculaFUB().equalsIgnoreCase(matriculaFUB)) {
				break;
			}
		}
		if(i>numProfessores) {
			return false;
		}
		else {
			professores[i] = p;
		}
		return true;
	}
}