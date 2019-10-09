package TP3;

public class TasBinaire {
	
	private int tailleFixe;
	private int nbCle;
	private int[] tableau;
	
	public TasBinaire(){
		this.tailleFixe=15;
		this.nbCle=0;
		this.tableau = new int[this.tailleFixe];
		
		this.tableau[0]=53;
		this.tableau[1]=41;
		this.tableau[2]=30;
		this.tableau[3]=36;
		this.tableau[4]=28;
		this.tableau[5]=21;
		this.tableau[6]=6;
		this.tableau[7]=31;
		this.tableau[8]=16;
		this.tableau[9]=20;
		
		this.nbCle=10;
		//this.tableau[10]=53;	//ajouter par l'utilisateur
	}
	
	public TasBinaire(int tailleFixe)
		throws NombreCleException {
			if(tailleFixe<1)
				throw new NombreCleException();
			else{
				this.tailleFixe=tailleFixe;
				this.nbCle=0;
				this.tableau = new int[tailleFixe];
			}
	}
	
	public void ajouterCle(int valeur) throws LimiteTableauException {
		System.out.println("nbCle (avant): " + this.nbCle);
		if(nbCle<tailleFixe){
			this.tableau[nbCle]=valeur;
			/*
			int nbBoucle = (int) (Math.log(nbCle) / Math.log(2));
			int pereCle = nbCle/2;
			*/
			System.out.println("---(this.nbCle/2)-1 : " + this.getNbCle()/2 );
			int pereCle = (this.nbCle/2)-1;
			System.out.println("pereCle 1 : " + pereCle);
			
			
			int nbBoucle = (int) (Math.log(this.nbCle) / Math.log(2));
			
			System.out.println("nbBoucle : " + nbBoucle);
			
			int i=0;
			
			while(nbBoucle>i){
				System.out.println(this.tableau[pereCle]);
				if( ((int)(pereCle/2)) > 0 ){
					pereCle = (int)(pereCle/2) - 1;
				}
				else{
					pereCle = 0;
				}
				nbBoucle--;
			}
			
			this.nbCle++;
			System.out.println("nbCle (apres): " + this.nbCle);
		}
		else{
			throw new LimiteTableauException();
		}
	}

	public int getTailleFixe(){
		return this.tailleFixe;
	}
	
	public int getNbCle(){
		return this.nbCle;
	}
	
	public int getCleTableau(int nEff){
		if(nEff>=0 && nEff<nbCle)
			return this.tableau[nEff];
		return -1;
	}
	
	public String toString(){
		String s = new String("| ");
		for(int i=0; i<tailleFixe; i++)
			s = s + this.tableau[i] + " | ";
		return s;
	}
	
}
