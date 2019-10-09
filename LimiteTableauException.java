package TP3;

public class LimiteTableauException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LimiteTableauException(){
		System.err.println("WARNING : Taille du tableau atteint !");
	}
	
}
