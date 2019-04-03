
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class JFX_Grille {

	public GridPane g1 = new GridPane();
	public GridPane g2 = new GridPane();

	public Button resultat;
	public Button inventaire;
	public Label labelinventory;
	
	public Inventaire inv = new Inventaire();
	Button blocks_aff;
	
    
	public JFX_Grille() {
		//Grille
		int a=1;
		for (int i = 1; i<4; i++) {
			for (int j = 0; j<3; j++) {
				Button b = new Button();
				b.setTextFill(null);
				b.setText("Button"+a); a+= 1;
				b.setPrefSize(80,80);

				g1.add(b, j, i);
				g1.setLayoutX(100);
				g1.setLayoutY(80);

				b.setOnAction(new EventHandler<ActionEvent>() { 

					@Override 
					public void handle(ActionEvent actionEvent) { 
						System.out.println(b.getText());
						g2.setVisible(true);
						labelinventory.setVisible(true);
					} 
				});
			}
		}
		
		//Resultat
		resultat = new Button();
		resultat.setText("R�sultat");
		resultat.setTextFill(null);
		resultat.setPrefSize(80, 80);
		resultat.setTranslateX(400);
		resultat.setTranslateY(160);
		resultat.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
			}
		});

		
		//Bouton inventaire permanant
		inventaire = new Button("Afficher l'inventaire");
		inventaire.setStyle("");
		inventaire.setTranslateX(10);
		inventaire.setTranslateY(10);
		inventaire.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent actionEvent) {
				inv.AjouterBlock(new Block(0, "Sand", false, null));
				for(int a = 0; a < 42; a++) {
					System.out.println(inv.inv.get(a).libelle);
				}
			}
		});
		

		
		//Boutton
		for(int i = 0; i < inv.inv.size(); i++) {
			blocks_aff = new Button();
			blocks_aff.setId("Image"+inv.inv.get(i).libelle);
			blocks_aff.setText("Button"+i);
			blocks_aff.setTextFill(null);
			blocks_aff.setPrefSize(40, 40);
			blocks_aff.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent actionEvent) {
					g2.setVisible(false);
					labelinventory.setVisible(false);
					System.out.println(blocks_aff.getId());
				}
			});
			g2.setPadding(new Insets(50, 0, 0, 0));
			g2.add(blocks_aff, (int)i%14, (int)i/14);
		}
		
		labelinventory = new Label();
		labelinventory.setId("labelinv");
		labelinventory.setText("Inventaire");
		labelinventory.setTranslateX(260);
		labelinventory.setTranslateY(350);
		labelinventory.setVisible(false);

		g2.setId("g2");
		g2.setVisible(false);
		
	}

}
