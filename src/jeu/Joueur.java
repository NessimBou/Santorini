package jeu;

import java.util.ArrayList;
import java.util.List;

public class Joueur {

	private ArrayList<Batiment> bat;
	private ArrayList<Pion> p;
	
	
	public Joueur(String nom){
		//bat = new ArrayList<Batiment>();
		p = new ArrayList<Pion>();
		/**for (int i = 0; i < 25 ; i++){
			Batiment b1 = new Batiment("etage",1);
			Batiment b2 = new Batiment("etage",2);
			Batiment b3 = new Batiment("etage",3);
			Batiment b4 = new Batiment("dome",4);
			bat.add(b1);
			bat.add(b2);
			bat.add(b3);
			bat.add(b4);
		}*/
		Pion p1 = new Pion(nom+".1",null);
		Pion p2 = new Pion(nom+".2",null);
		
		p.add(p1);
		p.add(p2);
	}
	/**
	public ArrayList<Batiment> listBat(){
		return bat;
	}*/
	
	public ArrayList<Pion> listPion(){
		return p;	
	}
	

	
	private void construction(){
		
	}
}
