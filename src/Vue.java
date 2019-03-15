import java.awt.Color;
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

	public static ArrayList<JButton> tab;
	private JPanel panel = new JPanel();

	public Vue() {
		this.setTitle("Minecraft - Crafting Helper");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.addMouseListener(this);

		this.setResizable(false);
		panel.setLayout(null);
		CreerTable();

		this.setSize(500, 500);
		this.setBackground(Color.decode("#c6c6c6"));
		this.setVisible(true);
	}

	public void CreerTable() {
		Craft c = new Craft(0);
		int a;

		for(int i = 0; i < c.matrice.length; i++) {
			for(int j = 0; j < c.matrice[0].length; j++) {

				JButton Button = new JButton();
				Button.setName("Button"+((j+1)+(3*i)));
				Button.setBackground(Color.decode("#8b8b8b"));
				Button.setBorder(new LineBorder(Color.BLACK));
				Button.addActionListener(this);
				if(i != 0 || j != 0) { a =2; } else{ a =0; }
				Button.setBounds((500/2)-120+80*i+a*(i), 20+80*j+a*j, 80, 80);
				panel.add(Button);
			}
		}

		this.add(panel);
	}

	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		System.out.println(e.equals("Button1"));
	}


	public static void main(String[] args) {
		Vue v = new Vue();

		Block buche = new Block(2, "Buche", true, new Craft(4));
		Block planche = new Block(0, "Planche", false, new Craft(4));
		planche.craft.setCraft("---", "-#-", "---");
		planche.craft.setElement(1, 1, buche);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}

}
