
import java.util.ArrayList;

public class Inventaire extends ArrayList<Item>{

	public Inventaire() {
		super();
		for(int a=0; a < 42; a++) {
			this.add(new Item("dirt", false, null));
		}
		
	}
}




