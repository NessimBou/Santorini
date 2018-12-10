package interfacegraphique;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Grille extends JPanel  implements  MouseListener {

	private int x,y;
	private Color couleur=Color.white;
	
	public Grille(int x, int y){
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.addMouseListener(this);
		this.x=x;
		this.y=y;
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("vous avez cliqueé ici"+arg0.getX()+"-"+arg0.getY()+'-'+arg0.getClickCount());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void paintComponent(Graphics g){
		Rectangle r=g.getClipBounds();
		g.setColor(couleur);
		g.fillRect(0,0,r.width,r.height);
		// sans changer la couleur, on ne voit rien !
		g.drawString("HelloWord",10,10);
		}

}
