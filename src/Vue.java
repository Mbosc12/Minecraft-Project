import javafx.application.Application;

import javafx.geometry.Insets;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;

public class Vue extends Application{
	
	public BorderPane top = new BorderPane();
	public BorderPane bottom = new BorderPane();
	
	public Group root = new Group();
	public Scene scene = new Scene(root, 600, 600);
	
	public JFX_Grille grille = new JFX_Grille();
	
	public String css = getClass().getResource("application.css").toExternalForm();

	

	//Application 
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setScene(scene);
		
		scene.getStylesheets().add(css);
		primaryStage.setResizable(false);
	

		top.setTop(grille.g1);
		top.setPadding(new Insets(80, 5, 5, 100));
	
		
		bottom.setTop(grille.g2);
		bottom.setPadding(new Insets(350, 20, 0, 20));
		
		root.getChildren().add(bottom);
		root.getChildren().add(top);
		
		root.getChildren().add(grille.labelinventory);
		root.getChildren().add(grille.resultat);
		root.getChildren().add(grille.inventaire);

		primaryStage.show();
	}
	
	
	
	public static void main(String[] args) {
		Inventaire v = new Inventaire();
		Application.launch(Vue.class, args);
		System.out.println("test");
	}
 }