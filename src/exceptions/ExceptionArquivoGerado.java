package exceptions;

import javax.swing.JOptionPane;

public class ExceptionArquivoGerado extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExceptionArquivoGerado() {
		JOptionPane.showMessageDialog(null, "C�digo gerado com sucesso.");
	}
}
