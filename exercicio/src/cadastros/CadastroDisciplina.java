package cadastros;

import app.Disciplinas;

public class CadastroDisciplina {
	int numDisciplinas; 
	private Disciplinas[] disciplinas; 
	
	public CadastroDisciplina() {
		numDisciplinas = 0;
		disciplinas = new Disciplinas[0];
	}
	
	public int cadastrarDisciplina(Disciplinas d) {
		Disciplinas[] temp = new Disciplinas[numDisciplinas + 1];
		for (int i=0; i < disciplinas.length; i++) {
			temp[i] = disciplinas[i];
		}
		temp[temp.length -1] = d; 
		disciplinas = temp;
		numDisciplinas++; 
		
		return numDisciplinas;
	}
	
	public Disciplinas pesquisarDisciplina(String codigoD) {
		Disciplinas resposta =  null;
		for (int i=0; i < disciplinas.length; i++) {
			Disciplinas d = disciplinas[i];
			String mat = d.getCodigoD(); 
			if (mat.equalsIgnoreCase(codigoD)) {
				return disciplinas[i];
			}
		}
		return resposta;
	}
	
	public boolean removerDisciplina(Disciplinas d) {
		Disciplinas remover = null; 
		if (d != null)
			remover = pesquisarDisciplina(d.getCodigoD());
		
		if (remover == null) {
			return false;
		} 
		
		Disciplinas[] temp = new Disciplinas[numDisciplinas - 1];
		int j=0;
		for (int i=0; i<numDisciplinas; i++) {
			if (disciplinas[i] != remover) {
				temp[j] = disciplinas[i];
				j++;
			} else {
				disciplinas[i] = null;
			}
		}
		disciplinas = temp; 
		numDisciplinas--;
		return true;
	}
	
	public boolean atualizarDisciplinas(String codigoD, Disciplinas d) {
		int i;
		for (i=0; i< 11; i++) {
			if (disciplinas[i].getCodigoD().equalsIgnoreCase(codigoD)) {
				break;
			}
		}
		if (i > numDisciplinas) {
			return false;
		} else {
			disciplinas[i] = d;
		}
		return true;
	}
}
