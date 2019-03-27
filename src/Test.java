import java.awt.BorderLayout;

import javax.print.DocFlavor.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Dimension2D;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Test extends Application {

	public BorderPane top = new BorderPane();
	public BorderPane bottom = new BorderPane();
	public GridPane g1 = new GridPane();
	
	final FlowPane barreDuBas = new FlowPane(); 
	
	public static void main(String[] args) {
		Scene scene = new Scene(new Group(), 500, 400);
		
		scene.getStylesheets().add("application.css");
		
		
		Application.launch(Test.class, args);

		Test v = new Test();

		Block buche = new Block(2, "Buche", true, new Craft(4));
		Block planche = new Block(0, "Planche", false, new Craft(4));
		planche.craft.setCraft("---", "-#-", "---");
		planche.craft.setElement(1, 1, buche);
	}
	@Override
	public void start(Stage primaryStage) {
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);
		primaryStage.setScene(scene);
		String css = getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
		
		/*java.net.URL cssURL = getClass().getResource("application.css");
		if (cssURL != null) {
		  scene.getStylesheets().add(cssURL.toExternalForm());
		}*/

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
						bottom.setVisible(true);
					} 
				});
			}
		}
		
		 

		
		
		
		Button resultat = new Button();
		resultat.setText("Résultat");
		resultat.setTextFill(null);
		resultat.setPrefSize(80, 80);
		resultat.setTranslateX(400);
		resultat.setTranslateY(160);
		resultat.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				System.out.println(resultat.getText());
			}
		});
		root.getChildren().add(resultat);


		Button inventaire = new Button("Afficher l'inventaire");
		inventaire.setTranslateX(10);
		inventaire.setTranslateY(10);
		root.getChildren().add(inventaire);
		
		top.setTop(g1);
		top.setPadding(new Insets(80, 5, 5, 100));
		root.getChildren().add(top);

		
		//bottom.setPadding(new Insets(10,400,5,100));
		barreDuBas.setId("barreDuBas");
		barreDuBas.setPrefSize(500, 100);
		bottom.setLayoutX(0);
		bottom.setLayoutY(400);
	
		bottom.setBottom(barreDuBas);
		bottom.setVisible(false);
		root.getChildren().add(bottom);
		
		primaryStage.show();
	}



}
