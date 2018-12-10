package jeu;

public class Pion {
	private String nom;
	private Case c;
	private int mouvement ;
	private int construction;
	
	public Pion(String nom, Case c ){
		this.nom = nom;
		this.c = c;
		this.mouvement = 1;
		this.construction = 1;
				
	}
	
	public Case getCase(){
		return c;
	}
	
	public String getNom(){
		return nom;
	}
	
	public void setCase(Case c){
		this.c = c;
	}
	
	public int getMouvement(){
		return mouvement;
	}
	
	public void bouger(){
		mouvement = 0 ;
	}
	
	public void nouveauTour(){
		mouvement = 1;
		construction = 1 ;
	}
	
	public void contruction(){
		construction = 0 ;
	}
	/**
	 * Savoir si la partie est finie
	 * @return True/false
	 */
	public boolean partieFinie(){
		if(c.getEtage() == 3){
			return true;
		}
		return false;
	}
}
	