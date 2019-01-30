package jeu;


 
public class Case {
	private int ligne;
	private int colonne;
	private String contenu;
	private int etage;
	
	public Case(int ligne,int colonne,String contenu){
		this.ligne = ligne;
		this.colonne = colonne;
		this.contenu = contenu;
		this.etage = 0;
	}
	
	public String getContenu(){
		return contenu;
	}
	
	public int getLigne(){
		return ligne;
	}
	public int getColonne(){
		return colonne;
	}
	
	public boolean isVide(){
		if(contenu == "" || contenu == null){
			return true;
		}else{
			return false;
		}
	}
	
	public int getEtage(){
		return etage;
	}
	public void setEtage(int e){
		this.etage = e;
	}
	
	public void setContenu(String contenu){
		this.contenu = contenu;
	}
}
