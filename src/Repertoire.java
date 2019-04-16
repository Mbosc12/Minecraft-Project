import java.util.HashMap;

public class Repertoire{
	HashMap<Integer, Item> rep;
	
	public Repertoire() {
		
		this.rep = new HashMap<Integer, Item>();
		
		rep.put(0, new Item("vide", false, null, null));
		
		rep.put(1, new Item("dirt", true, "block", null));
		
		rep.put(2, new Item("bois", false, "block", new Craft(new Item[][] {
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(0),rep.get(1),rep.get(1)},
			{rep.get(0),rep.get(1),rep.get(1)}
		})));
		
		rep.put(10, new Item("bois", false, "block", new Craft(new Item[][] {
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(0),rep.get(1),rep.get(1)},
			{rep.get(0),rep.get(1),rep.get(1)}
		})));
		
		rep.put(3, new Item("pierre", false, "block", new Craft(new Item[][] {
			{rep.get(1),rep.get(1),rep.get(1)},
			{rep.get(1),rep.get(1),rep.get(1)},
			{rep.get(1),rep.get(1),rep.get(1)}
		})));
		rep.put(4, new Item("sand", false, "block", new Craft(new Item[][] {
			{rep.get(1),rep.get(1),rep.get(1)},
			{rep.get(1),rep.get(1),rep.get(1)},
			{rep.get(1),rep.get(1),rep.get(1)}
		})));
	}
}
