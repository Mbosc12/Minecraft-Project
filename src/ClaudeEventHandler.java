import javafx.event.Event;
import javafx.event.EventHandler;

public class ClaudeEventHandler implements EventHandler<Event>{

	private boolean vide = true;
	
	public ClaudeEventHandler() {
		super();
	}
	
	@Override
	public void handle(Event e) {
		System.out.println(e.toString());
//		if (this.vide) {
//			System.out.println("Je prends");
//			this.vide = false;
//		} else {
//			System.out.println("Je dépose");
//			this.vide = true;
//		}
		
	}

}
