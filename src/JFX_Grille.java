import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.TransferMode;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class JFX_Grille {

	public GridPane g1 = new GridPane();
	public GridPane g2 = new GridPane();

	public Button resultat;
	public Button inventaire;
	public Label labelinventory;

	public Inventaire inventory = new Inventaire();

	public Button blocks_aff;

	@SuppressWarnings("unchecked")
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

				// EVENEMENTS
				b.setOnAction(new EventHandler<ActionEvent>() { 
					@Override 
					public void handle(ActionEvent actionEvent) { 
						System.out.println(b.getText());
						g2.setVisible(true);
						labelinventory.setVisible(true);
					} 
				});
				b.setOnDragOver(new EventHandler <DragEvent>() {
					public void handle(DragEvent event) {
						if (event.getGestureSource() != b && event.getDragboard().hasString()) {
							event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
						}

						event.consume();
					}
				});
				b.setOnDragDropped(new EventHandler <DragEvent>() {
					public void handle(DragEvent event) {
						System.out.println("onDragEntered");
						if (event.getGestureSource() != b && event.getDragboard().hasString()) {
							b.setId(blocks_aff.getId());
						}
						event.consume();
					}
				});
			}
		}

		//Resultat
		resultat = new Button();
		resultat.setText("Résultat");

		resultat.setTextFill(null);
		resultat.setPrefSize(80, 80);
		resultat.setTranslateX(400);
		resultat.setTranslateY(160);
		resultat.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				inventory.get(1).libelle = "case";
			}
		});

		//Bouton inventaire permanent
		inventaire = new Button("Afficher l'inventaire");
		inventaire.setStyle("");
		inventaire.setTranslateX(10);
		inventaire.setTranslateY(10);
		InventoryEventHandler ieh = new InventoryEventHandler(this.inventory, blocks_aff);
		inventaire.setOnAction(ieh);

		//Boutons inventaire 
		for(int i = 0; i < inventory.size(); i++) {
			blocks_aff = new Button();
			blocks_aff.setId("image"+inventory.get(i).libelle);
			blocks_aff.setPrefSize(40, 40);
			
			// EVENEMENTS 
			
			blocks_aff.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent actionEvent) {
					g2.setVisible(false);
					labelinventory.setVisible(false);
					System.out.println(blocks_aff.getText());
				}
			});
			blocks_aff.setOnDragExited(new EventHandler <DragEvent>() {
				public void handle(DragEvent event) {
					g2.setVisible(false);
					labelinventory.setVisible(false);

					event.consume();
				}
			});

			blocks_aff.setOnDragDetected(new EventHandler <MouseEvent>() {
				public void handle(MouseEvent event) {
					Dragboard db = blocks_aff.startDragAndDrop(TransferMode.ANY);
					//db.setDragView(new Image(new File("..dirt.png")));

					ClipboardContent content = new ClipboardContent();
					content.putUrl("../dirt_ico.png");
					content.putString(blocks_aff.getText());
					db.setContent(content);
					System.out.println(content);

					event.consume();
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

