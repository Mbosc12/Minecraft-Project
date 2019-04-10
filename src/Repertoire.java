import java.util.HashMap;

public class Repertoire{
	HashMap<Integer, Item> rep;
	
	public Repertoire() {
		
		this.rep = new HashMap<Integer, Item>();
		
		rep.put(0, new Item("vide", false, null));
		
		rep.put(1, new Item("dirt", true, null));
		
		rep.put(2, new Item("bois", false, new Craft(new Item[][] {
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(0),rep.get(1),rep.get(1)},
			{rep.get(0),rep.get(1),rep.get(1)}
		})));
		
		rep.put(10, new Item("bois", false, new Craft(new Item[][] {
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(0),rep.get(1),rep.get(1)},
			{rep.get(0),rep.get(1),rep.get(1)}
		})));
		
		rep.put(3, new Item("pierre", false, new Craft(new Item[][] {
			{rep.get(1),rep.get(1),rep.get(1)},
			{rep.get(1),rep.get(1),rep.get(1)},
			{rep.get(1),rep.get(1),rep.get(1)}
		})));
		rep.put(4, new Item("sand", false, new Craft(new Item[][] {
			{rep.get(1),rep.get(1),rep.get(1)},
			{rep.get(1),rep.get(1),rep.get(1)},
			{rep.get(1),rep.get(1),rep.get(1)}
		})));
	}
}
