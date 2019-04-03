import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class Inventaire extends JPanel{

	public ArrayList<Block> inv = new ArrayList<>();

	public BorderPane bottom;
	public Button blocks_aff; 

	public Inventaire() {

		this.inv = new ArrayList<>();
		for(int a=0; a < 42; a++) {

			inv.add(new Block(a, "dirt", false, null));

		}
		//Affichage inventaire temporaire

		bottom = new BorderPane();

		for(int i = 0; i < inv.size(); i++) {
			blocks_aff = new Button();
			blocks_aff.setId("a");
			blocks_aff.setText("Button"+i);
			blocks_aff.setPrefSize(60, 40);
			bottom.setBottom(blocks_aff);
		}
		bottom.setLayoutX(0);
		bottom.setLayoutY(350);
		bottom.setVisible(true);

	}

}
