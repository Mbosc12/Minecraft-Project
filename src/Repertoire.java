import java.util.HashMap;
public class Repertoire{
	
	HashMap<Integer, Item> rep;
	
	public Repertoire() {
		
		this.rep = new HashMap<Integer, Item>();
		
		rep.put(0, new Item("vide", true, "block", null));
		
		rep.put(1, new Item("terre", true, "block", null));
		
		rep.put(2, new Item("pierre", true, "block", null));
		
		rep.put(3, new Item("buche", true, "block", null));

		rep.put(4, new Item("planche", false, "block", new Craft(new Item[][] {
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(0),rep.get(3),rep.get(0)},
			{rep.get(0),rep.get(0),rep.get(0)}
		})));
		
		rep.put(5, new Item("dalle_pierre", false, "block", new Craft(new Item[][] {
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(4),rep.get(4),rep.get(4)}
		})));
		
		rep.put(6, new Item("escalier_bois", false, "block", new Craft(new Item[][] {
			{rep.get(4),rep.get(0),rep.get(0)},
			{rep.get(4),rep.get(4),rep.get(0)},
			{rep.get(4),rep.get(4),rep.get(4)}
		})));
		
		rep.put(7, new Item("porte_bois", false, "block", new Craft(new Item[][] {
			{rep.get(0),rep.get(4),rep.get(4)},
			{rep.get(0),rep.get(4),rep.get(4)},
			{rep.get(0),rep.get(4),rep.get(4)}
		})));
		
		rep.put(8, new Item("baton", false, "item", new Craft(new Item[][] {
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(0),rep.get(4),rep.get(0)},
			{rep.get(0),rep.get(4),rep.get(0)}
		})));
		
		rep.put(9, new Item("barriere_bois", false, "block", new Craft(new Item[][] {
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(4),rep.get(8),rep.get(4)},
			{rep.get(4),rep.get(8),rep.get(4)}
		})));
		
		rep.put(10, new Item("baton", false, "item", new Craft(new Item[][] {
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(0),rep.get(4),rep.get(0)},
			{rep.get(0),rep.get(4),rep.get(0)}
		})));
		
		rep.put(11, new Item("bloc_diamant", false, "block", new Craft(new Item[][] {
			{rep.get(4),rep.get(4),rep.get(4)},
			{rep.get(4),rep.get(0),rep.get(4)},
			{rep.get(4),rep.get(4),rep.get(4)}
		})));
		

	}
}