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
		
		rep.put(5, new Item("tablecraft", false, "block", new Craft(new Item[][] {
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(4),rep.get(4),rep.get(0)},
			{rep.get(4),rep.get(4),rep.get(0)}
		})));
		
		rep.put(6, new Item("coffre", false, "block", new Craft(new Item[][] {
			{rep.get(4),rep.get(4),rep.get(4)},
			{rep.get(4),rep.get(0),rep.get(4)},
			{rep.get(4),rep.get(4),rep.get(4)}
		})));
		
		rep.put(7, new Item("baton", false, "item", new Craft(new Item[][] {
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(0),rep.get(4),rep.get(0)},
			{rep.get(0),rep.get(4),rep.get(0)}
		})));
		
		rep.put(8, new Item("pioche_bois", false, "outil", new Craft(new Item[][] {
			{rep.get(4),rep.get(4),rep.get(4)},
			{rep.get(0),rep.get(7),rep.get(0)},
			{rep.get(0),rep.get(7),rep.get(0)}
		})));
		
		rep.put(9, new Item("epee_pierre", false, "outil", new Craft(new Item[][] {
			{rep.get(0),rep.get(2),rep.get(0)},
			{rep.get(0),rep.get(2),rep.get(0)},
			{rep.get(0),rep.get(7),rep.get(0)}
		})));
		
		rep.put(10, new Item("pioche_pierre", false, "outil", new Craft(new Item[][] {
			{rep.get(2),rep.get(2),rep.get(2)},
			{rep.get(0),rep.get(7),rep.get(0)},
			{rep.get(0),rep.get(7),rep.get(0)}
		})));
		
		rep.put(11, new Item("pelle_pierre", false, "outil", new Craft(new Item[][] {
			{rep.get(0),rep.get(2),rep.get(0)},
			{rep.get(0),rep.get(7),rep.get(0)},
			{rep.get(0),rep.get(7),rep.get(0)}
		})));
		
		rep.put(12, new Item("four", false, "block", new Craft(new Item[][] {
			{rep.get(2),rep.get(2),rep.get(2)},
			{rep.get(2),rep.get(0),rep.get(2)},
			{rep.get(2),rep.get(2),rep.get(2)}
		})));
		
		rep.put(13, new Item("charbon", false, "minerai", null));
		
		
		rep.put(14, new Item("torche", false, "item", new Craft(new Item[][] {
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(0),rep.get(13),rep.get(0)},
			{rep.get(0),rep.get(7),rep.get(0)}
		})));
		
		rep.put(15, new Item("lingot_fer", false, "minerai", null));
		
		
		rep.put(16, new Item("cisailles", false, "item", new Craft(new Item[][] {
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(0),rep.get(15),rep.get(0)},
			{rep.get(0),rep.get(0),rep.get(15)}
		})));
		
		rep.put(17, new Item("laine", false, "block", null));
		
		
		rep.put(18, new Item("lit", false, "block", new Craft(new Item[][] {
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(17),rep.get(17),rep.get(17)},
			{rep.get(4),rep.get(4),rep.get(4)}
		})));
		
		rep.put(19, new Item("porte_bois", false, "block", new Craft(new Item[][] {
			{rep.get(4),rep.get(4),rep.get(0)},
			{rep.get(4),rep.get(4),rep.get(0)},
			{rep.get(4),rep.get(4),rep.get(0)}
		})));
		
		rep.put(20, new Item("casque_fer", false, "outil", new Craft(new Item[][] {
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(15),rep.get(15),rep.get(15)},
			{rep.get(15),rep.get(0),rep.get(15)}
		})));
		
		rep.put(21, new Item("plastron_fer", false, "outil", new Craft(new Item[][] {
			{rep.get(15),rep.get(0),rep.get(15)},
			{rep.get(15),rep.get(15),rep.get(15)},
			{rep.get(15),rep.get(15),rep.get(15)}
		})));
		
		rep.put(22, new Item("jambiere_fer", false, "outil", new Craft(new Item[][] {
			{rep.get(15),rep.get(15),rep.get(15)},
			{rep.get(15),rep.get(0),rep.get(15)},
			{rep.get(15),rep.get(0),rep.get(15)}
		})));
		
		rep.put(23, new Item("bottes_fer", false, "outil", new Craft(new Item[][] {
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(15),rep.get(0),rep.get(15)},
			{rep.get(15),rep.get(0),rep.get(15)}
		})));
		
		rep.put(24, new Item("diamant", false, "minerai", null));
		
		rep.put(25, new Item("epee_diamant", false, "outil", new Craft(new Item[][] {
			{rep.get(0),rep.get(24),rep.get(0)},
			{rep.get(0),rep.get(24),rep.get(0)},
			{rep.get(0),rep.get(7),rep.get(0)}
		})));
		
		rep.put(26, new Item("pioche_diamant", false, "outil", new Craft(new Item[][] {
			{rep.get(24),rep.get(24),rep.get(24)},
			{rep.get(0),rep.get(7),rep.get(0)},
			{rep.get(0),rep.get(7),rep.get(0)}
		})));
		
		rep.put(27, new Item("obsidienne", false, "block", null));
		
		rep.put(28, new Item("lingot_or", false, "minerai", null));
		
		rep.put(29, new Item("emeraude", false, "minerai", null));
		
		rep.put(30, new Item("quartz", false, "minerai", null));
		
		rep.put(31, new Item("pierre_lisse", false, "block", null));
		
		rep.put(32, new Item("pierre_taillee", false, "block", new Craft(new Item[][] {
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(31),rep.get(31),rep.get(0)},
			{rep.get(31),rep.get(31),rep.get(0)}
		})));
		
		rep.put(33, new Item("pierre_sculptee", false, "block", new Craft(new Item[][] {
			{rep.get(0),rep.get(0),rep.get(0)},
			{rep.get(32),rep.get(32),rep.get(0)},
			{rep.get(32),rep.get(32),rep.get(0)}
		})));
		
		rep.put(34, new Item("sable", false, "block", null));
		
		rep.put(35, new Item("poudre", false, "item", null));
		
		rep.put(36, new Item("tnt", false, "block", new Craft(new Item[][] {
			{rep.get(35),rep.get(34),rep.get(35)},
			{rep.get(34),rep.get(35),rep.get(34)},
			{rep.get(35),rep.get(34),rep.get(35)}
		})));
		
		rep.put(37, new Item("brique", false, "block", null));
		
		rep.put(38, new Item("escalier_bois", false, "block", new Craft(new Item[][] {
			{rep.get(4),rep.get(0),rep.get(0)},
			{rep.get(4),rep.get(4),rep.get(0)},
			{rep.get(4),rep.get(4),rep.get(4)}
		})));
		
		rep.put(39, new Item("redstone", false, "minerai", null));
		
		rep.put(40, new Item("montre", false, "item", new Craft(new Item[][] {
			{rep.get(0),rep.get(28),rep.get(0)},
			{rep.get(28),rep.get(39),rep.get(28)},
			{rep.get(0),rep.get(28),rep.get(0)}
		})));
		
		
		
		

	}
}