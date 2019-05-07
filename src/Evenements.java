import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Evenements {


	public ScrollPane evnts = new ScrollPane();
	public GridPane gridevent = new GridPane();

	ArrayList<Label> eventlist = new ArrayList<Label>();
	public Evenements() {

		
		eventlist.add(new Label("Veuiller faire une table de craft !"));
		eventlist.add(new Label("Veuiller faire une pioche avec votre bois !"));
		eventlist.add(new Label("Utiliser la pioche en bois pour en faire une en pierre!"));
		eventlist.add(new Label("Vous allez vite avoir besoin d'un coffre !"));
		eventlist.add(new Label("Vous avez trouver du fer, vite faites un four !"));
		eventlist.add(new Label("Vous devriez faire votre equipement en fer !"));
		eventlist.add(new Label("Ne serait-ce pas du diamant ?"));
		eventlist.add(new Label("Il vaudrait mieux se faire un abris !"));
		eventlist.add(new Label("Amusez-vous, vous avez débloquer plusieurs items !"));
		
		for(int i = 0; i < eventlist.size(); i++) {
			if(i%2 == 0) {
				eventlist.get(i).setId("labelevent");
			}
			else {
				eventlist.get(i).setId("labelevent2");
			}
			eventlist.get(i).setPrefSize(280, 40);	
			eventlist.get(i).setAlignment(Pos.CENTER);
			
			gridevent.add(eventlist.get(i), 0, i);
			gridevent.setVgap(1);	
		}

		evnts.setPannable(true);
		evnts.setContent(gridevent);
		evnts.setId("evnts");
		evnts.setPrefSize(300, 355);


	}

	public void estverif(int i, boolean b) {
		if(b == true) {
			if(i%2 == 0) {
				this.eventlist.get(i).setId("accompli2");
				this.eventlist.get(i).setTextFill(Color.WHITE);
			}
			else {
				this.eventlist.get(i).setId("accompli");
			}
		}
	}
	

}
