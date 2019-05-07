
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class CraftArea {

	Inventaire iv = new Inventaire();
	Combinaison c = new Combinaison();
	Evenements evnt = new Evenements();

	public FlowPane craftarea = new FlowPane();

	public GridPane tablearea = new GridPane();

	public FlowPane resultat = new FlowPane();


	ArrayList<Item> CraftList = new ArrayList<Item>();

	Item pardef = iv.r.rep.get(0);

	public CraftArea() {

		for(int z = 0; z < 9; z++) {
			CraftList.add(new Item("vide", false, null, null));
		}

		//Container
		craftarea.setLayoutX(200);
		craftarea.setId("craftarea");
		craftarea.setPrefSize(910, 355);
		craftarea.setAlignment(Pos.CENTER_LEFT);
		craftarea.setPadding(new Insets(0, 0, 0, 170));


		//Table

		tablearea.setPrefSize(244, 244);
		tablearea.setId("tablearea");
		tablearea.setAlignment(Pos.CENTER);
		tablearea.setHgap(2);
		tablearea.setVgap(2);

		AjouterSlot(0, CraftList.get(0));
		AjouterSlot(1, CraftList.get(1));
		AjouterSlot(2, CraftList.get(2));
		AjouterSlot(3, CraftList.get(3));
		AjouterSlot(4, CraftList.get(4));
		AjouterSlot(5, CraftList.get(5));
		AjouterSlot(6, CraftList.get(6));
		AjouterSlot(7, CraftList.get(7));
		AjouterSlot(8, CraftList.get(8));

		craftarea.getChildren().add(tablearea);

		//Resultat

		resultat.setPrefSize(80, 80);
		resultat.setId("resultat");
		resultat.setLayoutX(700);
		resultat.setLayoutY(135);
		resultat.setAlignment(Pos.CENTER);
		resultat.getChildren().add(this.pardef);
		resultat.setOnMousePressed(event -> {
			for(int i = 0; i < 9; i++ ) {
				AjouterSlot(i, new Item("vide", false, null, null)); 
				c.matrice[i%3][i/3] = iv.it.libelle;
			}
			resultat.getChildren().add(new Item("vide", false, null, null));
			int exist=0;
			boolean ex = false;
			while(exist < iv.size() && ex == false) {
				if(iv.get(exist).libelle == "vide") {
					ex = true;
				}
				else {
					exist++;	
				}
			}

			if(ex == true) {
				Item rs = (Item) resultat.getChildren().get(0);
				rs.setFitHeight(40);
				rs.setFitWidth(40);
				iv.AjouterItem(rs, exist);
				iv.bloc_dec.add(rs);
			}
			
			//LES RESULTATS EVENT
			System.out.println(iv.bloc_dec.get(iv.bloc_dec.size()-1).libelle);
			if(iv.bloc_dec.get(iv.bloc_dec.size()-1).libelle == "tablecraft") {
				evnt.estverif(0, true);
			}
			else if(iv.bloc_dec.get(iv.bloc_dec.size()-1).libelle == "pioche_bois") {
				evnt.estverif(1, true);
			}
			else if(iv.bloc_dec.get(iv.bloc_dec.size()-1).libelle == "pioche_pierre") {
				evnt.estverif(2, true);
			}
			else if(iv.bloc_dec.get(iv.bloc_dec.size()-1).libelle == "coffre") {
				evnt.estverif(3, true);
				iv.AjouterItem(iv.r.rep.get(15), exist+1);
			}
			else if(iv.bloc_dec.get(iv.bloc_dec.size()-1).libelle == "four") {
				evnt.estverif(4, true);
				iv.AjouterItem(iv.r.rep.get(15), exist+1);
			}
			else if(iv.bloc_dec.get(iv.bloc_dec.size()-1).libelle == "epee_fer") {
				evnt.estverif(5, true);
			}
			else if(iv.bloc_dec.get(iv.bloc_dec.size()-1).libelle == "pioche_fer") {
				evnt.estverif(6, true);
				iv.AjouterItem(iv.r.rep.get(15), exist+1);
			}
			else if(iv.bloc_dec.get(iv.bloc_dec.size()-1).libelle == "pierre_lisse") {
				evnt.estverif(7, true);
			}
			else if(iv.bloc_dec.get(iv.bloc_dec.size()-1).libelle == "porte_bois") {
				evnt.estverif(8, true);
				int avanc = 0;
				for(int i = 1; i < iv.r.rep.size(); i++) {
					if(!iv.bloc_dec.contains(iv.r.rep.get(i))) {
						avanc++;
						iv.AjouterItem(iv.r.rep.get(i), exist);
						iv.bloc_dec.set(avanc, iv.r.rep.get(i));
					}
		}
			}
		});


	}

	public void AjouterSlot(int i, Item it) {
		FlowPane tableslot = new FlowPane();
		tableslot.setId("tableslot"+i);
		tableslot.setPrefSize(80, 80);
		tableslot.setAlignment(Pos.CENTER);
		tableslot.getChildren().add(it);

		tableslot.setOnDragOver(event -> {
			if (event.getGestureSource() != tableslot && event.getDragboard().hasString()) {
				event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
			}
			event.consume();
		}
				);
		tableslot.setOnDragDropped(event -> {
			if (event.getGestureSource() != tableslot && event.getDragboard().hasString()) {
				if(iv.it != null) {
					Integer temp = Integer.parseInt(tableslot.getId().substring(9));

					tableslot.getChildren().remove(0);
					iv.it.setFitHeight(64);
					iv.it.setFitWidth(64);
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
				);

		tableslot.setOnMousePressed(event -> {
			if(iv.it != null) {
				Integer temp = Integer.parseInt(tableslot.getId().substring(9));
				if(event.isPrimaryButtonDown() && iv.it.libelle != "vide") {
					tableslot.getChildren().remove(0);
					iv.it.setFitHeight(64);
					iv.it.setFitWidth(64);
					tableslot.getChildren().add(iv.it);	

					c.matrice[temp%3][temp/3] = iv.it.libelle;
				}
				if(event.isSecondaryButtonDown()) {
					if(!((FlowPane) event.getSource()).getChildren().isEmpty()) {
						if(((Item)((FlowPane) event.getSource()).getChildren().get(0)).libelle != "vide") {
							tableslot.getChildren().add(CraftList.get(temp));
							tableslot.getChildren().remove(0);
							c.matrice[temp%3][temp/3] = CraftList.get(temp).libelle;
						}
					}
				}

				boolean res = false;

				for(int t = 0; t < iv.r.rep.size(); t++){
					if (iv.r.rep.get(t).craft != null && c.verification(iv.r.rep.get(t).craft.matrice)) {
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

			iv.it = this.pardef;
		});

		tablearea.add(tableslot, i/3, i%3);
	}

}

