package jeu;

public class Grille {
	private int hauteur;
	private int largeur; 
	private Case[][] plateau ;
	
	public Grille(int hauteur, int largeur){
		this.hauteur = hauteur;
		this.largeur = largeur;
		plateau = new Case[hauteur][largeur];
		for(int i = 0;  i < hauteur; i++){
			for(int j = 0; j< largeur;j++){
				plateau[i][j]= new Case(i,j,"");
			}
		}
	}
	
	/**
	 * SAvoir si la case est hors de la grille 
	 * @param c La case en question 
	 * @return True/False
	 */
	public boolean horsLimite(Case c){
		if(c.getLigne() >= this.hauteur || c.getLigne() < 0 || c.getColonne() >= this.largeur || c.getColonne() < 0){
			System.out.println("La case n'existe pas");
			return true;
		}else{
			return false;
		}
	}
	
	
	public Case getCase(int i,int j){
		if(i >= this.hauteur || i < 0 || j >= this.largeur || j < 0){
			System.out.println("La case n'existe pas");
			return null;
		}else{
			return plateau[i][j];
		}
	}
	public int getHauteur(){
		return hauteur;
	}
	public int getLargeur(){
		return largeur;
	}
	

	
}
