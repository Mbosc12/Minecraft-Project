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
		
		rep.put(5, new Item("diamant", true, "minerai", new Craft(new Item[][] {
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(0),rep.get(0),rep.get(0)}
		})));
		
		rep.put(6, new Item("block_diamant", false, "block", new Craft(new Item[][] {
			{rep.get(5),rep.get(5),rep.get(5)},
			{rep.get(5),rep.get(5),rep.get(5)},
			{rep.get(5),rep.get(5),rep.get(5)}
		})));
		rep.put(7, new Item("Pepite_d'or", true, "minerai", new Craft(new Item[][] {
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(0),rep.get(0),rep.get(0)}
		})));
		rep.put(8, new Item("Lingot_d'or", true, "minerai", new Craft(new Item[][] {
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(0),rep.get(0),rep.get(0)}
		})));
		rep.put(9, new Item("Redstone", true, "minerai", new Craft(new Item[][] {
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(0),rep.get(0),rep.get(0)}
		})));
		rep.put(10, new Item("Montre", false, "item", new Craft(new Item[][] {
			{rep.get(0),rep.get(8),rep.get(0)},
			{rep.get(8),rep.get(9),rep.get(8)},
			{rep.get(0),rep.get(8),rep.get(0)}
		})));
		rep.put(11, new Item("Lingot_de_fer", true, "minerai", new Craft(new Item[][] {
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(0),rep.get(0),rep.get(0)}
		})));
		rep.put(12, new Item("Boussole", false, "item", new Craft(new Item[][] {
			{rep.get(0),rep.get(11),rep.get(0)},
			{rep.get(11),rep.get(9),rep.get(11)},
			{rep.get(0),rep.get(11),rep.get(0)}
		})));
		rep.put(13, new Item("Cisailles", false, "item", new Craft(new Item[][] {
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(0),rep.get(11),rep.get(0)},
			{rep.get(11),rep.get(0),rep.get(0)}
		})));
		
		rep.put(14, new Item("Baton", true, "minerai", new Craft(new Item[][] {
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(0),rep.get(0),rep.get(0)}
		})));
		
		rep.put(15, new Item("piochepierre", true, "item", new Craft(new Item[][] {
			{rep.get(11),rep.get(11),rep.get(11)},
			{rep.get(0),rep.get(14),rep.get(0)},
			{rep.get(0),rep.get(14),rep.get(0)}
		})));
		
		rep.put(16, new Item("boisbouleau", false, "block", new Craft(new Item[][] {
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(0),rep.get(0),rep.get(0)}
		})));
		
		rep.put(17, new Item("piochebasique", true, "item", new Craft(new Item[][] {
			{rep.get(16),rep.get(16),rep.get(16)},
			{rep.get(0),rep.get(14),rep.get(0)},
			{rep.get(0),rep.get(14),rep.get(0)}
		})));
		
		
	}
}
