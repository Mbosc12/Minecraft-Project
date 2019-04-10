import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class InventoryEventHandler implements EventHandler {

	Inventaire inventory;
	Button bouton;
	public InventoryEventHandler(Inventaire i, Button b) {
		this.inventory = i;
		this.bouton = b;
	}
	
	@Override
	public void handle(Event arg0) {
		bouton.setId("image"+inventory.get(1).libelle);
	}

}
