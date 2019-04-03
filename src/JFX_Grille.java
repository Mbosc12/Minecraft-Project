
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.TransferMode;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class JFX_Grille {

	public GridPane g1 = new GridPane();
	public GridPane g2 = new GridPane();

	public Button resultat;
	public Button inventaire;
	public Label labelinventory;

	public Inventaire inv = new Inventaire();

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
				b.setOnDragOver(new EventHandler <DragEvent>() {
					public void handle(DragEvent event) {
						/* data is dragged over the target */
						//System.out.println("onDragOver");

						/* accept it only if it is  not dragged from the same node 
						 * and if it has a string data */
						if (event.getGestureSource() != b && event.getDragboard().hasString()) {
							/* allow for both copying and moving, whatever user chooses */
							event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
						}

						event.consume();
					}
				});
				b.setOnDragDropped(new EventHandler <DragEvent>() {
					public void handle(DragEvent event) {
						/* the drag-and-drop gesture entered the target */
						System.out.println("onDragEntered");
						/* show to the user that it is an actual gesture target */
						if (event.getGestureSource() != b && event.getDragboard().hasString()) {
							b.setId("a");
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
				System.out.println(resultat.getText());
				inv.inv.add(new Block(0, "test", false, null));
				System.out.println(inv.inv.size());
			}
		});


		//Bouton inventaire permanent
		inventaire = new Button("Afficher l'inventaire");
		inventaire.setStyle("");
		inventaire.setTranslateX(10);
		inventaire.setTranslateY(10);


		//Boutons inventaire 
		for(int i = 0; i < inv.inv.size(); i++) {
			Button blocks_aff = new Button();
			blocks_aff.setId("a");
			blocks_aff.setText("Button"+i);
			blocks_aff.setTextFill(null);
			blocks_aff.setPrefSize(40, 40);
			blocks_aff.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent actionEvent) {
					g2.setVisible(false);
					labelinventory.setVisible(false);
				}
			});

			blocks_aff.setOnDragDetected(new EventHandler <MouseEvent>() {
				public void handle(MouseEvent event) {
					/* drag was detected, start drag-and-drop gesture*/
					System.out.println("onDragDetected");

					/* allow any transfer mode */
					Dragboard db = blocks_aff.startDragAndDrop(TransferMode.ANY);

					/* put a string on dragboard */
					ClipboardContent content = new ClipboardContent();
					content.putString(blocks_aff.getText());
					db.setContent(content);
					System.out.println(content);

					event.consume();
				}
			});

			blocks_aff.setOnDragEntered(new EventHandler <DragEvent>() {
				public void handle(DragEvent event) {
					blocks_aff.setId("a");

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

