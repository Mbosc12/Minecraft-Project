import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreGridLayout extends JFrame {

	private static final int TAILLE_BOUTON = 50;

	private final String lettres[]={"a","b","c","d","e","f","g","h"};

	FenetreGridLayout(){
		super("Test GridLayout ");
		this.setSize(800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel grille = new JPanel();
		this.setContentPane(grille);
		grille.setLayout(new GridLayout(8,8));
		this.setVisible(true);
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				Color couleur = ((i+j) % 2 == 0) ? Color.WHITE : Color.GRAY;
				JButton bouton = new JButton();
				bouton.setBackground(couleur);
				bouton.setPreferredSize(new Dimension(TAILLE_BOUTON, TAILLE_BOUTON));
				bouton.setActionCommand(lettres[j]+(8-i));
				JPanel pan = new JPanel();
				pan.add(bouton);
				this.add(pan);
			}
		}
	}
	
	public static void main(String[] args) {
		FenetreGridLayout fn = new FenetreGridLayout();

	}

	
}
