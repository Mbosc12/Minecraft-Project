import java.awt.Event;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class CraftArea {

	Repertoire r = new Repertoire();
	Inventaire iv = new Inventaire();
	Combinaison c = new Combinaison();
	
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
			
			tableslot.setOnMousePressed(event -> {
				if(iv.it != null) {
					tableslot.getChildren().remove(0);
					tableslot.getChildren().add(iv.it);	
					
					Integer temp = Integer.parseInt(tableslot.getId().substring(9));
					
					c.matrice[temp%3][temp/3] = iv.it.libelle;
					/*
					for(int t = 0; t < iv.r.rep.size(); t++){
						if (iv.r.rep.get(t).craft != null && c.verification(iv.r.rep.get(t).craft.matrice) == true) {
							System.out.println("ok");
						}
					
					}*/
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
