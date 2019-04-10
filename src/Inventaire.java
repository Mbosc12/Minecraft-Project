import java.util.ArrayList;

public class Inventaire{

	public ArrayList<Item> inv = new ArrayList<>();

	public Inventaire() {

		this.inv = new ArrayList<>();
		inv.add(new Item ("Pilier_de_quartz", false, null));
		for(int a=1; a < 42; a++) {
			inv.add(new Item("dirt", false, null));
		}
		
		
	}
}