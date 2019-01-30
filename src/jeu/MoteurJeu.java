package jeu;

import java.util.Scanner;

public class MoteurJeu {

	private boolean findepartie = false;
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
			System.out.print(i + " "); 
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
			while(!finDePartie()){
				System.out.println("c'est au joueur 1 de jouer");
				Pion pion = phaseBougerPion(p,g1,J1,sc);
				phaseConstruction( p,g1,pion,sc);
				System.out.println("fin du tour du joueur 1");
				System.out.println("c'est au joueur2 de jouer ");
				pion = phaseBougerPion(p,g1,J2,sc);
				phaseConstruction( p,g1,pion,sc);
				System.out.println("fin du tour du joueur 2");
				nouveauTour(J1,J2);
			}
			break;
			
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
					Case c = g1.getCase(ligne,colonne);
					
					//si la case est hors de la grille
					if(g1.horsLimite(c)){
						System.out.println("Choissisez une ligne compris entre 1 et 5:");
						ligne =  sc.nextInt();
						System.out.println("Choissisez une colonne compris entre 1 et 5:");
						colonne =  sc.nextInt();
						c = g1.getCase(ligne,colonne);
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
								c = g1.getCase(ligne,colonne);	
							}
							grille[ligne][colonne] = J1.listPion().get(0).getNom();
							afficherGrille();
							
						}else{
							while(!p.PoserPion(J1.listPion().get(1),c)){
								System.out.println("La case choisis est occupe");
								System.out.println("Choissisez une ligne compris entre 1 et 5:");
								ligne =  sc.nextInt();
								System.out.println("Choissisez une colonne compris entre 1 et 5:");
								colonne =  sc.nextInt();
								c = g1.getCase(ligne,colonne);	

							}
						
							grille[ligne][colonne] = J1.listPion().get(1).getNom();
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
								c = g1.getCase(ligne,colonne);	
							}
							grille[ligne][colonne] = J2.listPion().get(0).getNom();
							afficherGrille();
							
						}else{
							while(!p.PoserPion(J2.listPion().get(1),c)){
								System.out.println("La case choisis est occupe");
								System.out.println("Choissisez une ligne compris entre 1 et 5:");
								ligne =  sc.nextInt();
								System.out.println("Choissisez une colonne compris entre 1 et 5:");
								colonne =  sc.nextInt();
								c = g1.getCase(ligne,colonne);	

							}
						
							grille[ligne][colonne] = J2.listPion().get(1).getNom();
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
	
	
	public Pion phaseBougerPion(Plateau p , Grille g, Joueur j,Scanner sc){
		if(findepartie){
			System.out.println("La partie est terminé");
			return null;
		}
		System.out.println("Vous devez maintenant bouger un pion");
		System.out.println("Choissisez quel pion vous voulez bouger");
		int num = sc.nextInt();
		int ancienligne ;
		int ancienColonne ;
		
		
		if(num == 3){
			System.out.println("Le pion 1 est :ligne = "+j.listPion().get(0).getCase().getLigne()+", colonne= "+j.listPion().get(0).getCase().getColonne());
			System.out.println("Le pion 2 est :ligne = "+j.listPion().get(1).getCase().getLigne()+", colonne= "+j.listPion().get(1).getCase().getColonne());
			System.out.println("Vous devez maintenant bouger un pion");
			System.out.println("Choissisez quel pion vous voulez bouger");
			num = sc.nextInt();
			
			ancienligne = j.listPion().get(num-1).getCase().getLigne();
			ancienColonne = j.listPion().get(num-1).getCase().getColonne();
			
		}else{
			ancienligne = j.listPion().get(num-1).getCase().getLigne();
			ancienColonne = j.listPion().get(num-1).getCase().getColonne();
		}
		System.out.println("Choississez une case");
		System.out.println("Choissisez une ligne:");
		int ligne =  sc.nextInt();
		System.out.println("Choissisez une colonne:");
		int colonne =  sc.nextInt();
		Case c = g.getCase(ligne,colonne);
		while(!p.bougerPion(j.listPion().get(num-1), c)){
			System.out.println("Choississez une case");
			System.out.println("Choissisez une ligne:");
			ligne =  sc.nextInt();
			System.out.println("Choissisez une colonne:");
			colonne =  sc.nextInt();
			c = g.getCase(ligne, colonne);
		}
		
		grille[ligne][colonne] = j.listPion().get(num-1).getNom();
		grille[ancienligne][ancienColonne] = "..";
		afficherGrille();
		if(j.listPion().get(num-1).partieFinie()){
			findepartie = true;
			return null;
		}
		return j.listPion().get(num-1);
	}
	
	
	public void phaseConstruction(Plateau p , Grille g, Pion pion , Scanner sc){
		if(findepartie){
			return;
		}
		System.out.println("Vous devez maintenant construire un etage");
		System.out.println("quel etage voulez vous construire?");
		int etage =sc.nextInt();
		Batiment t;
		while(etage > 4 || etage == 0){
			System.out.println("Vous devez choisir un nombre entre 1 et 4");
			System.out.println("Quel etage voulez-vous construire?");
			etage = sc.nextInt();
		}
		if(etage <= 3){
			t = new Batiment("etage",etage);
		}else{
			t = new Batiment("Dome",etage);
		}
		System.out.println("Choississez maintenant la case où vous voulez construire l'etage");
		System.out.println("Choissisez une ligne : ");
		int ligne = sc.nextInt();
		System.out.println("Choissisez maintenant une colonne");
		int colonne = sc.nextInt();
		
		Case c = g.getCase(ligne,colonne);
		//pion case batiment 
		while(!p.poserBatiment(pion, c, t)){
			System.out.println("Vous devez maintenant construire un etage");
			System.out.println("quel etage voulez vous construire?");
			etage =sc.nextInt();
			while(etage > 4 || etage == 0){
				System.out.println("Vous devez choisir un nombre entre 1 et 4");
				System.out.println("Quel etage voulez-vous construire?");
				etage = sc.nextInt();
			}
			if(etage <= 3){
				t = new Batiment("etage",etage);
			}else{
				t = new Batiment("Dome",etage);
			}
			
			System.out.println("Choississez maintenant la case où vous voulez construire l'etage");
			System.out.println("Choissisez une ligne : ");
			ligne = sc.nextInt();
			System.out.println("Choissisez maintenant une colonne");
			colonne = sc.nextInt();
			
		}
		if(c.getEtage() < 4){
			grille[ligne][colonne] = c.getContenu() + "etage" +c.getEtage();
		}else{
			grille[ligne][colonne] = c.getContenu();
			
		}
		afficherGrille();
		finDeTour();
	}
	
	
	public void finDeTour(){
		terminer = false;
		
	}	
	
	public void nouveauTour(Joueur j1, Joueur j2){
		j1.listPion().get(0).nouveauTour();
		j1.listPion().get(1).nouveauTour();
		j2.listPion().get(0).nouveauTour();
		j2.listPion().get(1).nouveauTour();
	}
	
	
	public boolean finDePartie(){
		if(findepartie){
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
}
