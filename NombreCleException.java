package TP3;

public class NombreCleException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NombreCleException(){
		System.err.println("ERREUR : Taille du tableau incorrect !");
		System.err.println("INSTANCIATION D'UN TABLEAU PAR DEFAUT...");
	}
	
}
