import java.awt.Event;
import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class CraftArea {

	Inventaire iv = new Inventaire();
	Combinaison c = new Combinaison();

	public FlowPane craftarea = new FlowPane();

	public GridPane tablearea = new GridPane();

	public FlowPane resultat = new FlowPane();

	ArrayList<Item> test = new ArrayList<Item>();

	Item pardef = new Item("vide", false, null, null);

	public CraftArea() {

		test.add(new Item("vide", false, null, null));
		test.add(new Item("vide", false, null, null));
		test.add(new Item("vide", false, null, null));
		test.add(new Item("vide", false, null, null));
		test.add(new Item("vide", false, null, null));
		test.add(new Item("vide", false, null, null));
		test.add(new Item("vide", false, null, null));
		test.add(new Item("vide", false, null, null));
		test.add(new Item("vide", false, null, null));

		//Container
		craftarea.setLayoutX(200);
		craftarea.setId("craftarea");
		craftarea.setPrefSize(910, 350);
		craftarea.setAlignment(Pos.CENTER_LEFT);
		craftarea.setPadding(new Insets(0, 0, 0, 170));


		//Table

		tablearea.setPrefSize(244, 244);
		tablearea.setId("tablearea");
		tablearea.setAlignment(Pos.CENTER);
		tablearea.setHgap(2);
		tablearea.setVgap(2);

		for(int i = 0; i < 9; i++) {
			FlowPane tableslot = new FlowPane();
			tableslot.setId("tableslot"+i);
			tableslot.setPrefSize(80, 80);
			tableslot.setAlignment(Pos.CENTER);
			tableslot.getChildren().add(test.get(i));

			tableslot.setOnDragOver(new EventHandler <DragEvent>() {
				public void handle(DragEvent event) {
					/* accept it only if it is  not dragged from the same node 
					 * and if it has a string data */
					if (event.getGestureSource() != tableslot && event.getDragboard().hasString()) {
						/* allow for both copying and moving, whatever user chooses */
						event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
					}

					event.consume();
				}
			});

			tableslot.setOnDragDropped(new EventHandler <DragEvent>() {
				public void handle(DragEvent event) {
					/* show to the user that it is an actual gesture target */
					if (event.getGestureSource() != tableslot && event.getDragboard().hasString()) {
						if(iv.it != null) {
							Integer temp = Integer.parseInt(tableslot.getId().substring(9));
							System.out.println("Je passe dans le bouton primaire");
							tableslot.getChildren().remove(0);
							tableslot.getChildren().add(iv.it);	

							c.matrice[temp%3][temp/3] = iv.it.libelle;
							
							boolean res = false;
							for(int t = 0; t < iv.r.rep.size(); t++){
								if (iv.r.rep.get(t).craft != null && c.verification(iv.r.rep.get(t).craft.matrice) == true) {
									resultat.getChildren().remove(0);
									resultat.getChildren().add(iv.r.rep.get(t).clone());
									res = true;
								}
								
								else if(res == false){
									resultat.getChildren().remove(0);
									resultat.getChildren().add(new Item("vide", false, null, null));
								}
							}
						} 


						iv.it = new Item("vide", false, null, null);
					}

					event.consume();
				}
			});

			tableslot.setOnMousePressed(event -> {
				if(iv.it != null) {
					Integer temp = Integer.parseInt(tableslot.getId().substring(9));
					if(event.isPrimaryButtonDown() && iv.it.libelle != "vide") {
						tableslot.getChildren().remove(0);
						tableslot.getChildren().add(iv.it);	

						c.matrice[temp%3][temp/3] = iv.it.libelle;
						boolean res = false;
						for(int t = 0; t < iv.r.rep.size(); t++){
							if (iv.r.rep.get(t).craft != null && c.verification(iv.r.rep.get(t).craft.matrice) == true) {
								resultat.getChildren().remove(0);
								resultat.getChildren().add(iv.r.rep.get(t).clone());
								res = true;
							}
							
							else if(res == false){
								resultat.getChildren().remove(0);
								resultat.getChildren().add(this.pardef);
							}
						}
					}
					if(event.isSecondaryButtonDown()) {
						//ICI
					}
				} 


				iv.it = this.pardef;
			});

			tablearea.add(tableslot, i/3, i%3);
		}

		craftarea.getChildren().add(tablearea);

		//Resultat

		resultat.setPrefSize(80, 80);
		resultat.setId("resultat");
		resultat.setLayoutX(700);
		resultat.setLayoutY(135);
		resultat.setAlignment(Pos.CENTER);
		resultat.getChildren().add(this.pardef);

	}

}

