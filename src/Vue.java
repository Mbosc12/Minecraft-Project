import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Vue extends Application{
	
	public Inventaire invcl = new Inventaire();
	public Evenements evntcl = new Evenements();
	public CraftArea craftcl = new CraftArea();
	
	public Group root = new Group();
	public Scene scene = new Scene(root, 900, 600);
	
	public String cssinv = getClass().getResource("inv.css").toExternalForm();
	public String csscraft = getClass().getResource("craft.css").toExternalForm();
	public String cssevent = getClass().getResource("event.css").toExternalForm();

	//Application 
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		scene.getStylesheets().add(cssinv);
		scene.getStylesheets().add(csscraft);
		scene.getStylesheets().add(cssevent);
		
		
		root.getChildren().add(craftcl.craftarea);
		root.getChildren().add(craftcl.resultat);
		root.getChildren().add(evntcl.evnts);
		
		root.getChildren().add(invcl.inventoryarea);
		root.getChildren().add(invcl.menuarea);
		root.getChildren().add(invcl.inventorygrid);
		primaryStage.show();
	}
	
	
	
	public static void main(String[] args) {
		Application.launch(Vue.class, args);
	}
 }