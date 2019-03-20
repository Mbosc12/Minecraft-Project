import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class AWT_Grille extends JPanel implements MouseListener{

	public JPanel panel = new JPanel();
	
	public AWT_Grille(ActionListener listener) {
		
		panel.setLayout(null);

		Craft c = new Craft(0);
		int a;

		/*
		 * Creation de la table
		 */
		for(int i = 0; i < c.matrice.length; i++) {
			for(int j = 0; j < c.matrice[0].length; j++) {

				JButton button = new JButton();
				button.setName("Button"+((i+1)+(3*j)));
				button.setBackground(Color.decode("#8b8b8b"));
				button.setBorder(new LineBorder(Color.BLACK));
				button.addActionListener(listener);
				if(i != 0 || j != 0) { a =2; } else{ a =0; }
				button.setBounds((500/2)-120+80*i+a*(i), 20+80*j+a*j, 80, 80);
				panel.add(button);
			}
		}

		
		/*
		 * Création des boutons
		 */
		JButton resultat = new JButton();
		
		resultat.setName("Résultat");
		resultat.setBackground(Color.decode("#aaaaaa"));
		resultat.setBorder(new LineBorder(Color.BLACK));
		resultat.setBounds(400, 102, 80, 80);
		
		
		JButton afficherInventaire = new JButton("Inventaire");
		
		afficherInventaire.setName("Résultat");
		afficherInventaire.setBackground(Color.decode("#aaaaaa"));
		afficherInventaire.setBorder(new LineBorder(Color.BLACK));
		afficherInventaire.setBounds(10, 20, 100, 50);
		
		panel.add(resultat);
		panel.add(afficherInventaire);
		
		this.add(panel);
		
		this.add(panel);

		
		
		panel.setPreferredSize(new Dimension(500, 500));
		
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

}
