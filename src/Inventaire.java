import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class Inventaire extends ArrayList<Item>{

	public FlowPane inventoryarea = new FlowPane();

	public GridPane inventorygrid = new GridPane();

	public FlowPane menuarea = new FlowPane();

	public FlowPane menublocks = new FlowPane();
	public FlowPane menuitems = new FlowPane();
	public FlowPane menuoutils = new FlowPane();
	public FlowPane menuminerais = new FlowPane();

	Item it;

	public Inventaire() {		
		super();

		for(int a=0; a < 48; a++) {
			if(a == 0) {
				this.add(new Item("diamant", false, "minerai", null));
			}
			else {
				this.add(new Item("dirt", false, "block", null));	
			}

			FlowPane p = new FlowPane();
			p.setPrefSize(48, 48);
			p.setAlignment(Pos.CENTER);
			p.getChildren().add(this.get(a));
			p.setId("inventoryslot");


			this.get(a).setOnDragDetected(new EventHandler <MouseEvent>() {
				public void handle(MouseEvent event) {

					/* allow any transfer mode */
					Dragboard db = p.startDragAndDrop(TransferMode.ANY);

					/* put a string on dragboard */
					ClipboardContent content = new ClipboardContent();
					content.putString(it.libelle);
					db.setContent(content);

					event.consume();
				}
			});


			this.get(a).setOnDragEntered(new EventHandler <DragEvent>() {
				public void handle(DragEvent event) {
					/* the drag-and-drop gesture entered the target */
					System.out.println("onDragEntered");
					
				}
			});


			this.get(a).setOnMousePressed(event -> {

				//System.out.println("Item ID :  INV -> " + ((Item) event.getSource()));
				this.it = ((Item) event.getSource()).clone();

			});

			inventorygrid.add(p, a%16, a/16);

		}


		//Partie inventaire --------------------------------------

		//InventoryARea

		inventoryarea.setPrefSize(910, 260);
		inventoryarea.setLayoutY(415);
		inventoryarea.setAlignment(Pos.CENTER);
		inventoryarea.setId("inventoryarea");

		//MenuArea
		menuarea.setPrefSize(910, 60);
		menuarea.setLayoutY(350);
		menuarea.setId("menuarea");

		menuarea.setMargin(menublocks, new Insets(0, 12, 0, 12));
		menuarea.setMargin(menuitems, new Insets(0, 12, 0, 12));
		menuarea.setMargin(menuoutils, new Insets(0, 12, 0, 12));
		menuarea.setMargin(menuminerais, new Insets(0, 12, 0, 12));

		menuarea.setAlignment(Pos.CENTER);


		//MenuCompo
		Item it_item = (new Item("Montre", false, "item", null));
		Item it_block = (new Item("dirt", false, "block", null));
		Item it_outil = (new Item("epee_diamant", false, "outil", null));
		Item it_minerai = (new Item("diamant", false, "minerai", null));

		menuitems.setPrefSize(75, 50);
		menuitems.setId("menuitems");
		menuitems.setAlignment(Pos.CENTER);
		menuitems.getChildren().add(it_item);

		menublocks.setPrefSize(75, 50);
		menublocks.setAlignment(Pos.CENTER);
		menublocks.setId("menublocks");
		menublocks.getChildren().add(it_block);

		menuoutils.setPrefSize(75, 50);
		menuoutils.setAlignment(Pos.CENTER);
		menuoutils.setId("menuoutils");
		menuoutils.getChildren().add(it_outil);

		menuminerais.setPrefSize(75, 50);
		menuminerais.setAlignment(Pos.CENTER);
		menuminerais.setId("menuminerais");
		menuminerais.getChildren().add(it_minerai);


		//On les ajoutes en tant qu'enfant de l'Area
		menuarea.getChildren().add(menublocks);
		menuarea.getChildren().add(menuitems);
		menuarea.getChildren().add(menuoutils);
		menuarea.getChildren().add(menuminerais);

		//inventaire
		inventorygrid.setVgap(2);
		inventorygrid.setHgap(2);
		inventorygrid.setId("inventorygrid");
		inventorygrid.setLayoutX(56);
		inventorygrid.setLayoutY(435);
	}
}