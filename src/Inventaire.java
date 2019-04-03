import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;

public class Inventaire extends JPanel{

	public ArrayList<Block> inv = new ArrayList<>();

	public BorderPane bottom;
	public Button blocks_aff; 

	StackPane stackPane = new StackPane();
	Image im;

	public Inventaire() {

		this.inv = new ArrayList<>();

		//Affichage inventaire temporaire
		for(int a = 0; a < 42; a++) {
			inv.add(new Block(0, "vide", false, null));
		}
		
		bottom = new BorderPane();

		for(int i = 0; i < inv.size(); i++) {

			Button blocks_aff = new Button();
			blocks_aff.setId("But"+i);
			blocks_aff.setText("Button"+i);
			blocks_aff.setTextFill(null);
			blocks_aff.setPrefSize(40, 40);
			bottom.setBottom(blocks_aff);
		}

		bottom.setLayoutX(0);
		bottom.setLayoutY(350);
		bottom.setVisible(true);

	}

	public void AjouterBlock(Block b) {

		Block ch = inv.get(b.ID);
		ch.libelle = b.libelle;
		ch.craft = b.craft;
		ch.primary = b.primary;

	}

}
