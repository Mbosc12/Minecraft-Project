
public class Item {

	public String libelle;
	public boolean primary;
	public Craft craft;

	public Item(String l, boolean p, Craft test) {
		this.libelle = l;
		this.primary = p;
		this.craft = test;
	}
}
