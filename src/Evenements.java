import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

public class Evenements{


	public ScrollPane evnts = new ScrollPane();
	public GridPane t = new GridPane();

	public ArrayList<String> evntlist = new ArrayList<String>();

	public Evenements() {
		for(int i = 0; i < 20; i++) {
			evntlist.add("Evenement "+ i + " : Debloquez le block ...");
			Label l = new Label();
			Label l1 = new Label();
			if(i%2 == 0) {
				l.setText(evntlist.get(i));
				l.setId("labelevent");
				l.setPrefSize(280, 35);	
				l.setAlignment(Pos.CENTER);	
			}
			else {
				l1.setText(evntlist.get(i));
				l1.setId("labelevent2");
				l1.setPrefSize(280, 35);
				l1.setAlignment(Pos.CENTER);		
			}
			t.add(l, 0, i);
			t.add(l1, 0, i);
			t.setVgap(1);
		}
		evnts.setPannable(true);
		evnts.setContent(t);
		evnts.setId("evnts");
		evnts.setPrefSize(300, 350);
		
		
	}

}
