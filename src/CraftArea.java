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
	
	public FlowPane craftarea = new FlowPane();
	
	public GridPane tablearea = new GridPane();
	
	public Pane resultat = new Pane();
	
	ArrayList<Item> test = new ArrayList<Item>();
	
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
							tableslot.getChildren().remove(0);
							tableslot.getChildren().add(iv.it);	
						}
						iv.it = new Item("vide", false, null, null);
					}

					event.consume();
				}
			});
			
			tableslot.setOnMousePressed(event -> {
				if(iv.it != null) {
					tableslot.getChildren().remove(0);
					tableslot.getChildren().add(iv.it);	
				}
				iv.it = new Item("vide", false, null, null);
			});
			
			tablearea.add(tableslot, i/3, i%3);
		}
		
		craftarea.getChildren().add(tablearea);
		
		//Resultat
		
		resultat.setPrefSize(80, 80);
		resultat.setId("resultat");
		resultat.setLayoutX(700);
		resultat.setLayoutY(135);
	}
	
}

