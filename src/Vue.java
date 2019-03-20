import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Vue extends JFrame implements MouseListener, ActionListener{
	
	public Inventaire inv = new Inventaire();
	public AWT_Grille grille;
	
	public static ArrayList<JButton> tab;

	public Vue() {
		this.setTitle("Minecraft - Crafting Helper");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.addMouseListener(this);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.setSize(500, 450);
		this.setBackground(Color.decode("#c6c6c6"));
		this.setVisible(true);		
		
		this.grille = new AWT_Grille(this);
		
	
		this.add(grille.panel, BorderLayout.NORTH);
			
		this.add(inv, BorderLayout.SOUTH);
		inv.setVisible(false);


	}



	public static void main(String[] args) {
		Vue v = new Vue();

		Block buche = new Block(2, "Buche", true, new Craft(4));
		Block planche = new Block(0, "Planche", false, new Craft(4));
		planche.craft.setCraft("---", "-#-", "---");
		planche.craft.setElement(1, 1, buche);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		this.inv.setVisible(true);
		
	}



}

