package jeu;

import java.util.Scanner;

public class MoteurJeu {

	private boolean terminer = false;
	private boolean blanc = true;
	private String[][] grille = { //
			{"","","","",""},//
			{"","","","",""},//
			{"","","","",""},//
			{"","","","",""},//
			{"","","","",""}};	

	/**
	 * Afficher le contenu de la grille dans la console.
	 */

	public MoteurJeu(){

	}

	public void afficherGrille(){
		System.out.println("  1  2  3  4  5"); 
		for(int i=0; i < 5; i++){
			System.out.print(i+1 + " "); 
			for(int j=0 ; j < 5; j++){
				if (grille[i][j] == ""){
					System.out.print(grille[i][j] + ".. ");
				}else{
					System.out.print(grille[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	public void modeConsole() {

		Grille g1 = new Grille(5,5);
		Plateau p  = new Plateau(g1);
		Scanner sc = new Scanner(System.in);
		System.out.println("Appuyer sur f pour arreter");
		char str = sc.nextLine().charAt(0);
		Joueur J1 = new Joueur("J1");
		Joueur J2 = new Joueur("J2");
		do{
			System.out.println("Bonjour et bienvenue dans Santorini");
			System.out.println("Veuillez choisir un chiffre entre 1 et 2");
			int num =  sc.nextInt();
			int random = 1 + (int)Math.random()*1;

			if(num == random){
				System.out.println("Vous commencez");
			}else{
				System.out.println("c'est à l'autre joueur de commencer");
			}
			phasePoserPion(g1,p,J1,J2,sc);
			phaseBougerPion(p,g1,J1,sc);

			afficherGrille();
			
		}while(str != 'f');
		System.out.println("Au revoir !");
	}
	
	public boolean terminer(){
		if(terminer){
			return true;
		}else{
			return false;
		}
	}
	
	public void phasePoserPion(Grille g1, Plateau p, Joueur J1, Joueur J2, Scanner sc){
		
		while(!terminer()){

			//boucle joueur 
			for(int j = 0; j < 2; j++){
				// boucle pion 
				for(int i=0; i < 2 ;i++){

					System.out.println("Choissisez une premiere case pour posez votre pion");
					System.out.println("Choissisez une ligne:");
					int ligne =  sc.nextInt();
					System.out.println("Choissisez une colonne:");
					int colonne =  sc.nextInt();
					System.out.println(ligne + " " + colonne);
					Case c = g1.getCase(ligne-1,colonne-1);
					
					//si la case est hors de la grille
					if(g1.horsLimite(c)){
						System.out.println("Choissisez une ligne compris entre 1 et 5:");
						ligne =  sc.nextInt();
						System.out.println("Choissisez une colonne compris entre 1 et 5:");
						colonne =  sc.nextInt();
						c = g1.getCase(ligne-1,colonne-1);
					}
					
					//J1
					if(j == 0){
						//pion 1 
						if(i == 0){
							while(!p.PoserPion(J1.listPion().get(0),c)){
								System.out.println("La case choisis est occupe");
								System.out.println("Choissisez une ligne compris entre 1 et 5:");
								ligne =  sc.nextInt();
								System.out.println("Choissisez une colonne compris entre 1 et 5:");
								colonne =  sc.nextInt();
								c = g1.getCase(ligne-1,colonne-1);	
							}
							grille[ligne-1][colonne-1] = J1.listPion().get(0).getNom();
							afficherGrille();
							
						}else{
							while(!p.PoserPion(J1.listPion().get(1),c)){
								System.out.println("La case choisis est occupe");
								System.out.println("Choissisez une ligne compris entre 1 et 5:");
								ligne =  sc.nextInt();
								System.out.println("Choissisez une colonne compris entre 1 et 5:");
								colonne =  sc.nextInt();
								c = g1.getCase(ligne-1,colonne-1);	

							}
						
							grille[ligne-1][colonne-1] = J1.listPion().get(1).getNom();
							afficherGrille();
						}
					}else{
						if(i == 0){
							while(!p.PoserPion(J2.listPion().get(0),c)){
								System.out.println("La case choisis est occupe");
								System.out.println("Choissisez une ligne compris entre 1 et 5:");
								ligne =  sc.nextInt();
								System.out.println("Choissisez une colonne compris entre 1 et 5:");
								colonne =  sc.nextInt();
								c = g1.getCase(ligne-1,colonne-1);	
							}
							grille[ligne-1][colonne-1] = J2.listPion().get(0).getNom();
							afficherGrille();
							
						}else{
							while(!p.PoserPion(J2.listPion().get(1),c)){
								System.out.println("La case choisis est occupe");
								System.out.println("Choissisez une ligne compris entre 1 et 5:");
								ligne =  sc.nextInt();
								System.out.println("Choissisez une colonne compris entre 1 et 5:");
								colonne =  sc.nextInt();
								c = g1.getCase(ligne-1,colonne-1);	

							}
						
							grille[ligne-1][colonne-1] = J2.listPion().get(1).getNom();
							afficherGrille();
							terminer = true;
						}
							
					}
				}

				System.out.println("Appuyer sur f pour arreter");
				//str = sc.nextLine().charAt(0);
			}

		}	
	}
	
	
	public void phaseBougerPion(Plateau p , Grille g, Joueur j,Scanner sc){
		
		System.out.println("Vous devez maintennat bouger un pion");
		System.out.println("Choissisez quel pion vous voulez bouger");
		int num = sc.nextInt();
		
		int ancienligne = j.listPion().get(num-1).getCase().getLigne();
		int ancienColonne = j.listPion().get(num-1).getCase().getColonne();
		
		
		System.out.println("Choississez une case");
		System.out.println("Choissisez une ligne:");
		int ligne =  sc.nextInt();
		System.out.println("Choissisez une colonne:");
		int colonne =  sc.nextInt();
		Case c = g.getCase(ligne-1,colonne-1);
		while(!p.bougerPion(j.listPion().get(num-1), c)){
			System.out.println("Choississez une case");
			System.out.println("Choissisez une ligne:");
			ligne =  sc.nextInt();
			System.out.println("Choissisez une colonne:");
			colonne =  sc.nextInt();
		}
		grille[ligne-1][colonne-1] = j.listPion().get(num-1).getNom();
		grille[ancienligne][ancienColonne] = "..";
		afficherGrille();
	}
	
	
	
	
	
	
	
	
	
	
	
}
