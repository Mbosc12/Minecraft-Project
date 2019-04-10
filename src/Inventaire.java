
import java.util.ArrayList;

public class Inventaire{

	public ArrayList<Item> inv = new ArrayList<>();

	public Inventaire() {

		this.inv = new ArrayList<>();
		for(int a=0; a < 42; a++) {
			inv.add(new Item("dirt", false, null));
		}
		
	}
}




