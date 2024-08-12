package exceptions;

import javax.swing.JOptionPane;

public class CampoEmBrancoException extends RuntimeException{
	public CampoEmBrancoException(String campo) {
		 JOptionPane.showMessageDialog(null,"O campo " + campo + " não pode estar em branco.");
    }

}
