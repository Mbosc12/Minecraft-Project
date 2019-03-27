

import javafx.application.Application;

import javafx.geometry.Insets;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;

public class Vue extends Application{
	
	public BorderPane top = new BorderPane();

	

	//Application 
	@Override
	public void start(Stage primaryStage) {
		Group root = new Group();
		
		Scene scene = new Scene(root, 500, 500);
		primaryStage.setScene(scene);
		
		String css = getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
		
		JFX_Grille grille = new JFX_Grille();
	
		top.setTop(grille.g1);
		top.setPadding(new Insets(80, 5, 5, 100));
		
		root.getChildren().add(top);
		root.getChildren().add(grille.resultat);
		root.getChildren().add(grille.inventaire);
		primaryStage.show();
	}
	
	
	
	
	
	public static void main(String[] args) {

		Application.launch(Vue.class, args);

		Vue v = new Vue();

		Block buche = new Block(2, "Buche", true, new Craft(4));
		Block planche = new Block(0, "Planche", false, new Craft(4));
		planche.craft.setCraft("---", "-#-", "---");
		planche.craft.setElement(1, 1, buche);

	}
}