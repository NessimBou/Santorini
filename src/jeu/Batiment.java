package jeu;

public class Batiment {

	private String nom;
	private int etage;
	//private String c;
	
	public Batiment(String nom,int etage){
		this.nom = nom;
		this.etage = etage;
		//this.c = c;
		
	}
	
	public String getNom(){
		return nom;
	}
	
	public int getEtage(){
		return etage;
	}
	/**
	 * Test pour savoir si on peut poser l'etage du batiment 
	 * @param e : etage sur la case
	 * @return True/false
	 */
	public boolean peutPoser(int e){
		//etage plus petit que ou egal à celui sur la case;
		if(etage <= e || etage >= e+2){
			return false;
		}else{
			if(e == 3 && etage != 4){
				return false;
			}else{
				return true;
			}
		}
		
	}
}
