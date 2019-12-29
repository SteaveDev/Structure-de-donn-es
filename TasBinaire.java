package TP3;

public class TasBinaire {
	/*
	 * TAS MIN
	 * 
	 * Pour TAS MAX -> il faut simplement changer le signe de
	 * while(Tas[positionAcutelle] > Tas[parent(positionAcutelle)]) qui est dans fonction inserer
	 * Integer.MAX_VALUE a la place de Integer.MIN_VALUE 
	 * 
	 */
	
	private int tailleMax;
	private int nbCle;
	private int[] Tas;
	
	/*
	 * Si l'utilisateur saisie la taille < 1
	 * Alors on lui affectera un tas binaire de taille 20 par defaut
	 */
	public TasBinaire(){
		this.tailleMax=20;
		this.nbCle=0;
		this.Tas = new int[this.tailleMax];
	}
	
	/*
	 * 
	 * Si la taille est <1 alors une exception est leve
	 * Sinon on leve une exception
	 * 
	 * Tas a une taille de 'taille+1' pour contrer les nombres a virgules lors de la division pour retrouver le pere ou le fils
	 */
	public TasBinaire(int taille)
		throws NombreCleException {
			if(taille<1)
				throw new NombreCleException();
			else{
				this.tailleMax=taille;
				this.nbCle=0;
				this.Tas = new int[taille+1];
				this.Tas[0] = Integer.MIN_VALUE;	
			}
	}
	
	private int parent(int pos){
		return pos / 2;
	}
	
	/*
	 * On echange permute la valeur de deux cases du tableau 
	 */
	private void echange(int fpos, int spos) { 
        int temp; 
        temp = Tas[fpos]; 
        Tas[fpos] = Tas[spos]; 
        Tas[spos] = temp; 
    }
	
	/*
	 * verifie chaque relation entre pere et fils pour voir si les conditions sont bonnes pour echanger ou non
	 * 
	 */
	public void inserer(int element) throws LimiteTableauException {
		if(nbCle<=tailleMax){	
			nbCle++;
			Tas[nbCle]=element;
			
			int positionAcutelle = nbCle;

			while(getCleTas(positionAcutelle) > getCleTas(parent(positionAcutelle))){
				echange(positionAcutelle, parent(positionAcutelle));
				positionAcutelle = parent(positionAcutelle);				
			}
		}
		else{
			throw new LimiteTableauException();
		}
	}

	private int enfantGauche(int pos){
		return (pos * 2);
	}
	
	private int enfantDroite(int pos){
		return (pos * 2) + 1;
	}
	
	public int getTailleMax(){
		return this.tailleMax;
	}
	
	public int getNbCle(){
		return this.nbCle;
	}
	
	public int getCleTas(int nEff){
		if(nEff>=0 && nEff<nbCle)
			return this.Tas[nEff];
		return -1;
	}
	
	public String toString(){
		String s = new String("| ");
		for(int i=1; i<=tailleMax; i++)
			s = s + Tas[i] + " | ";
		return s;
	}
	
}
