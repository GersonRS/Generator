package exceptions;

import javax.swing.JOptionPane;

public class ExceptionProcessoErro extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExceptionProcessoErro() {
		JOptionPane
				.showMessageDialog(
						null,
						"Erro ao gerar c�digo, algum processo esta impedindo a gera��o. Espera um pouco e tente novamente.");
	}

	public ExceptionProcessoErro(String arg0) {
		super(arg0);
	}

}
