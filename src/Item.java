import java.io.InputStream;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Item extends ImageView{

	public String libelle;
	public boolean primary;
	public Craft craft;
	public int ti = 40;
	public String typ;
	
	public Item(String l, boolean p, String t, Craft test) {
		this.libelle = l;
		this.primary = p;
		this.typ = t;
		this.craft = test;
		
		Class<?> classe = this.getClass();
		InputStream input = classe.getResourceAsStream("/images/" + l + ".png");
		this.setImage(new Image(input));
		this.setFitHeight(ti);
		this.setFitWidth(ti);
	}
	
	@Override
	public Item clone() {
		return new Item(
				this.libelle,
				this.primary,
				this.typ,
				this.craft
			);
	}
}
