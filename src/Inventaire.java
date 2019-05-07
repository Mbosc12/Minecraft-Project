import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class Inventaire extends ArrayList<Item> {

	public Repertoire r = new Repertoire();

	public ArrayList<Item> bloc_dec = new ArrayList<Item>();

	public FlowPane inventoryarea = new FlowPane();
	public FlowPane menuarea = new FlowPane();

	public FlowPane menuitems = new FlowPane();
	public FlowPane menublocks = new FlowPane();
	public FlowPane menuall = new FlowPane();
	public FlowPane menuoutils = new FlowPane();
	public FlowPane menuminerais = new FlowPane();

	public GridPane inventorygrid = new GridPane();

	GridPane CraftArea = new GridPane();

	Item it;

	public Inventaire() {
		super();

		CraftArea.setPrefSize(300, 355);
		CraftArea.setId("CraftArea");
		CraftArea.setAlignment(Pos.CENTER);
		CraftArea.setVgap(2);
		CraftArea.setHgap(2);
		CraftArea.setVisible(false);

		AjouterCraft(new Item("vide", false, null, null), 0);
		AjouterCraft(new Item("vide", false, null, null), 1);
		AjouterCraft(new Item("vide", false, null, null), 2);
		AjouterCraft(new Item("vide", false, null, null), 3);
		AjouterCraft(new Item("vide", false, null, null), 4);
		AjouterCraft(new Item("vide", false, null, null), 5);
		AjouterCraft(new Item("vide", false, null, null), 6);
		AjouterCraft(new Item("vide", false, null, null), 7);
		AjouterCraft(new Item("vide", false, null, null), 8);


		// Inventaire de bloc_decouvert - primaire
		for(int first=0; first < 48; first++) {
			this.add(new Item("vide", false, null, null));
		}

		for (int prim = 1; prim < 49; prim++) {
			if (prim < r.rep.size() && r.rep.get(prim).primary) {
				bloc_dec.add(r.rep.get(prim));
			} else {
				bloc_dec.add(new Item("vide", false, null, null));
			}
			AjouterItem(bloc_dec.get(prim-1), prim-1);
		}

		// Partie inventaire --------------------------------------

		// InventoryARea

		inventoryarea.setPrefSize(910, 260);
		inventoryarea.setLayoutY(415);
		inventoryarea.setAlignment(Pos.CENTER);
		inventoryarea.setId("inventoryarea");

		// inventaire
		inventorygrid.setVgap(2);
		inventorygrid.setHgap(2);
		inventorygrid.setId("inventorygrid");
		inventorygrid.setLayoutX(56);
		inventorygrid.setLayoutY(435);

		// MenuArea
		menuarea.setPrefSize(910, 60);
		menuarea.setLayoutY(355);
		menuarea.setId("menuarea");

		menuarea.setAlignment(Pos.CENTER);

		// MenuCompo
		Item it_item = (new Item("montre", false, "item", null));
		Item it_block = (new Item("terre", false, "block", null));
		Item it_all = (new Item("command_block", false, "minerai", null));
		Item it_outil = (new Item("epee_diamant", false, "outil", null));
		Item it_minerai = (new Item("diamant", false, "minerai", null));

		FlowPane.setMargin(menublocks, new Insets(0, 12, 0, 12));
		FlowPane.setMargin(menuitems, new Insets(0, 12, 0, 12));
		FlowPane.setMargin(menuall, new Insets(0, 12, 0, 12));
		FlowPane.setMargin(menuoutils, new Insets(0, 12, 0, 12));
		FlowPane.setMargin(menuminerais, new Insets(0, 12, 0, 12));

		menuitems.setPrefSize(75, 50);
		menuitems.setId("menuitems");
		menuitems.setAlignment(Pos.CENTER);
		menuitems.getChildren().add(it_item);
		menuitems.setOnMousePressed(event -> {
			for(int i = 0; i < 48; i++) {
				AjouterItem(new Item("vide", false, null, null), i);
			}
			int a = 0;
			for(int i = 0; i < bloc_dec.size(); i++) {
				if(bloc_dec.get(i).typ == "item") {
					AjouterItem(bloc_dec.get(i), a);
					a++;
				}
			}
		});

		menublocks.setPrefSize(75, 50);
		menublocks.setAlignment(Pos.CENTER);
		menublocks.setId("menublocks");
		menublocks.getChildren().add(it_block);
		menublocks.setOnMousePressed(event -> {
			for(int i = 0; i < 48; i++) {
				AjouterItem(new Item("vide", false, null, null), i);
			}
			int a = 0;
			for(int i = 0; i < bloc_dec.size(); i++) {
				if(bloc_dec.get(i).typ == "block") {
					AjouterItem(bloc_dec.get(i), a);
					a++;
				}
			}
		});

		menuall.setPrefSize(75, 50);
		menuall.setAlignment(Pos.CENTER);
		menuall.setId("menuall");
		menuall.getChildren().add(it_all);
		menuall.setOnMousePressed(event -> {
			for(int i = 0; i < 48; i++) {
				AjouterItem(bloc_dec.get(i), i);
			}
		});

		menuoutils.setPrefSize(75, 50);
		menuoutils.setAlignment(Pos.CENTER);
		menuoutils.setId("menuoutils");
		menuoutils.getChildren().add(it_outil);
		menuoutils.setOnMousePressed(event -> {
			for(int i = 0; i < 48; i++) {
				AjouterItem(new Item("vide", false, null, null), i);
			}
			int a = 0;
			for(int i = 0; i < bloc_dec.size(); i++) {
				if(bloc_dec.get(i).typ == "outil") {
					AjouterItem(bloc_dec.get(i), a);
					a++;
				}
			}
		});

		menuminerais.setPrefSize(75, 50);
		menuminerais.setAlignment(Pos.CENTER);
		menuminerais.setId("menuminerais");
		menuminerais.getChildren().add(it_minerai);
		menuminerais.setOnMousePressed(event -> {
			for(int i = 0; i < 48; i++) {
				AjouterItem(new Item("vide", false, null, null), i);
			}
			int a = 0;
			for(int i = 0; i < bloc_dec.size(); i++) {
				if(bloc_dec.get(i).typ == "minerai") {
					AjouterItem(bloc_dec.get(i), a);
					a++;
				}
			}
		});

		menuarea.getChildren().add(menuitems);
		menuarea.getChildren().add(menuminerais);
		menuarea.getChildren().add(menuall);
		menuarea.getChildren().add(menuoutils);
		menuarea.getChildren().add(menublocks);
	}

	public void AjouterItem(Item ite, int i) {
		this.set(i, ite);
		FlowPane p = new FlowPane();
		p.setPrefSize(48, 48);
		p.setAlignment(Pos.CENTER);
		p.getChildren().add(ite);
		p.setId("inventoryslot");
		inventorygrid.add(p, i % 16, i / 16);

		ite.setOnDragDetected(event -> {

			Dragboard db = p.startDragAndDrop(TransferMode.ANY);

			ClipboardContent content = new ClipboardContent();
			content.putString(it.libelle);
			Image im = new Image("/images/" + it.libelle + ".png", 48, 48, false, false);

			content.putImage(im);
			db.setContent(content);

			event.consume();
		});

		ite.setOnMousePressed(event -> {
			this.it = ((Item) event.getSource()).clone();
			
			if(event.isSecondaryButtonDown()){
				if(this.it.craft == null) {
					CraftArea.setVisible(false);
				}
				
				else if(this.it.primary != true) {
					for(int cra = 0; cra < 9; cra++) {
						AjouterCraft(this.it.craft.matrice[cra%3][cra/3].clone(), cra);
					}
					CraftArea.setVisible(true);
				}
			}
		});
	}

	public void AjouterCraft(Item it, int i) {
		FlowPane craftslot = new FlowPane();
		craftslot.setId("craftslot");
		craftslot.setPrefSize(70, 70);
		craftslot.setAlignment(Pos.CENTER);
		craftslot.getChildren().add(it);

		CraftArea.add(craftslot, i/3, i%3);
	}
}