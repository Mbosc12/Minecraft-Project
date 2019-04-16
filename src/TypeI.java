import java.util.ArrayList;

public class TypeI {

	ArrayList<Item> titem = new ArrayList<Item>();
	ArrayList<Item> tblock = new ArrayList<Item>();	
	ArrayList<Item> toutils = new ArrayList<Item>();
	ArrayList<Item> tminerai = new ArrayList<Item>();
	
	public TypeI(ArrayList<Item> all) {
	
		for(int i = 0; i < all.size(); i++) {
			if(all.get(i).typ.equals("item")){
				titem.add(all.get(i));
			}
			else if(all.get(i).typ.equals("block")){
				tblock.add(all.get(i));
			}
			else if(all.get(i).typ.equals("outil")){
				toutils.add(all.get(i));
			}
			else if(all.get(i).typ.equals("minerai")){
				tminerai.add(all.get(i));
			}
		}
	}
	
}
