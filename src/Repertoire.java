import java.util.HashMap;

public class Repertoire{
	
	HashMap<Integer, Item> rep;
	
	public Repertoire() {
		
		this.rep = new HashMap<Integer, Item>();
		
		rep.put(0, new Item("vide", false, null, null));
		
		rep.put(1, new Item("dirt", true, "block", null));
		
		rep.put(2, new Item("epee_diamant", false, "block", new Craft(new Item[][] {
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(0),rep.get(1),rep.get(1)},
			{rep.get(0),rep.get(1),rep.get(1)}
		})));
		
		rep.put(3, new Item("Pilier_de_quartz", false, "block", new Craft(new Item[][] {
			{rep.get(1),rep.get(1),rep.get(1)},
			{rep.get(1),rep.get(1),rep.get(1)},
			{rep.get(1),rep.get(1),rep.get(1)}
		})));
		rep.put(4, new Item("Montre", false, "block", new Craft(new Item[][] {
			{rep.get(1),rep.get(1),rep.get(1)},
			{rep.get(1),rep.get(1),rep.get(1)},
			{rep.get(1),rep.get(1),rep.get(1)}
		})));
		
		
	}
}
