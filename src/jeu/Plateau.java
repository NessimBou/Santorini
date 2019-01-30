package jeu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class Plateau {
	private HashMap<Pion,Case> plateau;
	private HashMap<Case,Batiment> listeBat;
	private Grille g1;
	
	public Plateau(Grille g){
		plateau = new HashMap<Pion,Case>();
		listeBat = new HashMap<Case,Batiment>();
		this.g1 = g;
	}
	/**
	 * Poser le pion au d�but de la game
	 * @param p pion du joueur
	 * @param c La case o� poser le pion
	 */
	public boolean PoserPion(Pion p,Case c){
		System.out.println(c.getContenu());
		if(p.getCase() == null && c.isVide() && !g1.horsLimite(c)){
			p.setCase(c);
			c.setContenu(p.getNom());
			System.out.println(c.getContenu());
			plateau.put(p,c);
			System.out.println("Le pion est pos�");
			return true;
		}else{
			System.out.println("Le pion n'est pas pos�");
			return false;
		}
	}
	/**
	 * Bouger le pion pendant la phase de mouvement
	 * @param p Le pion du joueur
	 * @param c La case o� poser le pion
	 */
	public boolean bougerPion(Pion p, Case c){
		if(!g1.horsLimite(c)){
			if(p.getMouvement() == 1){
				//if(((c.getLigne() == p.getCase().getLigne() || c.getLigne() < p.getCase().getLigne() -1 ) || c.getColonne() >= p.getCase().getColonne()+1 || c.getColonne() <= p.getCase().getColonne()-1)  && ( c.getColonne() != p.getCase().getColonne() && c.getLigne() != p.getCase().getLigne())){
				if((c.getLigne() == p.getCase().getLigne() -1 && c.getColonne() == p.getCase().getColonne()-1) ||(c.getLigne() == p.getCase().getLigne() -1  && c.getColonne() == p.getCase().getColonne())||(c.getLigne() == p.getCase().getLigne() -1  && c.getColonne() == p.getCase().getColonne() +1 )||(c.getLigne() == p.getCase().getLigne() && c.getColonne() == p.getCase().getColonne()-1)||(c.getLigne() == p.getCase().getLigne() && c.getColonne() == p.getCase().getColonne() +1)||(c.getLigne() == p.getCase().getLigne() +1 && c.getColonne() == p.getCase().getColonne()-1)||(c.getLigne() == p.getCase().getLigne()+1 && c.getColonne() == p.getCase().getColonne())||(c.getLigne() == p.getCase().getLigne() +1 && c.getColonne() == p.getCase().getColonne() + 1)) {
					p.getCase().setContenu("");
					p.setCase(c);
					p.bouger();
					c.setContenu(p.getNom());
					System.out.println("Le pion a boug� ");
					plateau.put(p,c);
					return true;
				}else{
					System.out.println("Le pion ne peut bouger que d'une case");
					return false;
				}
			}else{
				System.out.println("Le pion a deja boug�");
				return false;
			}
			
		}else{
			System.out.println("La case est hors limite");
			return false;
		}
	}
	/**
	 * affichage des valeurs dans la hashmap plateau (pour les tests)
	 */
	public void AfficherValeur(){
		Iterator it = plateau.keySet().iterator();
		System.out.println("Liste plateau: ");
		while (it.hasNext()){
   			Pion cle =  (Pion) it.next(); // tu peux typer plus finement ici
   			Case valeur = plateau.get(cle); // tu peux typer plus finement ici
   			System.out.println(cle.getCase().getLigne()+"-"+cle.getCase().getColonne()+"-"+valeur.getContenu()+"-"+valeur.getEtage());
		}
		
		Iterator ite = listeBat.keySet().iterator();
		System.out.println("Liste batiement :");
		while (ite.hasNext()){
   			Case cle =   (Case) ite.next(); // tu peux typer plus finement ici
   			Batiment valeur = listeBat.get(cle); // tu peux typer plus finement ici
   			System.out.println(cle.getLigne()+"-"+cle.getColonne()+"-"+cle.getContenu()+"-"+cle.getEtage()+"-"+valeur.getNom()+"-"+valeur.getEtage());
		}
	}
	
	
	
	
	public boolean poserBatiment(Pion p, Case c,Batiment b){
		if(p.getMouvement() == 0){
			if(!c.isVide()){
				System.out.println("la case n'est pas vide, impossible de poser un �tage");
				return false;
			}else{
				if(c.getContenu() == "etage" && c.getEtage() == 3 && b.getEtage() == 4){
					c.setEtage(b.getEtage());
					c.setContenu("Dome");
					listeBat.put(c, b);
					p.contruction();
					System.out.println("un Dome a �t� pos�");
					return true;
				}else{
					if(c.getContenu() == "etage" || c.isVide()){
						if(b.peutPoser(c.getEtage())){
							c.setEtage(b.getEtage());
							listeBat.put(c, b);
							p.contruction();
							System.out.println("Etage est pos�");
							return true;
						}else{
							System.out.println("impossible de poser un etage, etage trop grand par rapport � la base");
							return false;
						}		

					}else{
						System.out.println("impossible de poser un etage car il y a un"+ c.getContenu());
						return false;
					}
					
				}
			}
		}else{
			System.out.println("Le pion doit bouger avant de pouvoir construire");
			return false;
		}
	}
	


}	
