import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Inventaire extends JPanel{

	public ArrayList<Block> inv;
	
	public Inventaire() {
		
		this.inv = new ArrayList<>();
		
		this.setBackground(Color.decode("#c6c6c6"));
		this.setBorder(BorderFactory.createLineBorder(Color.decode("#8b8b8b")));
		this.setPreferredSize(new Dimension(500, 100));
	}
	
}
