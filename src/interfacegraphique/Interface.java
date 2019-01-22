package interfacegraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Interface extends JFrame implements ActionListener{

	private JPanel container =  new JPanel();
	
	private GridLayout grille = new GridLayout(5,5);
	private JButton[] tab_bouton = new JButton[5];
	private JFrame t = new JFrame();
	private Grille gr[][] = new Grille[5][5];
	private Dimension dim = new Dimension(50, 40);
	
	
	public Interface(){
		//taille de la fenetre
		this.setSize(1000, 1000);
		//titre de la fenetre
		this.setTitle("Santorini");
		//Fenetre se ferme que quand on appuie sur la croix
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//fenetre au centre de l'ecran
		this.setLocationRelativeTo(null);
		//pouvoir redimensionner la fenetre
		this.setResizable(false);
		//On initialise le conteneur avec tous les composants
		initComposant();
		//On ajoute le conteneur
		//this.setContentPane(t);
		this.setVisible(true);
	}

	public void initComposant() {
	
		for (short i=0;i<5;i++){
			for (short j=0;j<5;j++){
				this.getContentPane().add(new Grille(i,j));
			}
		}
		Border blackline = BorderFactory.createLineBorder(Color.black,1); 

		JPanel bouton = new JPanel();
	
		tab_bouton[0] = new JButton("Début de la partie");
		tab_bouton[0].setPreferredSize(dim);
		bouton.add(tab_bouton[0]);
		
		tab_bouton[1]= new JButton("1er etage");
		tab_bouton[1].setPreferredSize(dim);
		bouton.add(tab_bouton[1]);
		
		tab_bouton[2]= new JButton("2eme etage");
		tab_bouton[2].setPreferredSize(dim);
		bouton.add(tab_bouton[2]);
		
		tab_bouton[3]= new JButton("3eme etage");
		tab_bouton[3].setPreferredSize(dim);
		bouton.add(tab_bouton[3]);
		
		tab_bouton[4]= new JButton("Dome");
		tab_bouton[4].setPreferredSize(dim);
		bouton.add(tab_bouton[4]);
		
	
		//t.getContentPane().add(bouton);
		
//		/container.add(t,BorderLayout.NORTH);
		//container.add(grille);
//		/this.add(menu);
		container.add(bouton,BorderLayout.SOUTH);
		t.add(container)	;
		//this.setLayout(t);
		
		//t.setLayout(grille);
		//notre fenetre sera dans container
		//this.setContentPane(t);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
