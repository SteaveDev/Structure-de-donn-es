package TP3;

import java.util.Scanner;

public class Main {
	
	public static void main(String [] args){
		
		Scanner sc = new Scanner(System.in);
		int valeurCle;
		
		TasBinaire t1 = null;
		System.out.println("Saisir une taille fixe pour le tableau : ");
		
		try {
			t1 = new TasBinaire(sc.nextInt());
		}
		catch (NombreCleException e){
		}
		finally {
			if(t1==null)
				t1 = new TasBinaire();
		}
		
		while(true){
			System.out.println(t1);
			System.out.println("Saisir une valeur : ");
			valeurCle = sc.nextInt();
			try{
				t1.inserer(valeurCle);
			}
			catch(LimiteTableauException e){}			
		}
	}
}







