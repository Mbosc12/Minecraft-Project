
public class Block {
	
	public int ID;
	public String libelle;
	public boolean primary;
	public Craft craft;
	
	public Block(int ID, String l, boolean p, Craft c) {
		
		this.craft = c;
		this.ID = ID;
		this.libelle = l;
		this.primary = p;
		
	}
	
}
