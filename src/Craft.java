
public class Craft {

	public int res;
	public Block[][] matrice;
	public Block vide = new Block(0, "vide", true, null);

	public Craft() {

		this.matrice = new Block[][] {
			{vide, vide, vide},
			{vide, vide, vide},
			{vide, vide, vide}
		};

	}


	public void setCraft(Block[] l1, Block[] l2, Block[] l3) {

		Block[][] sol = {l1, l2, l3};

		for(int i=0; i < 3; i++) {
			for(int j=0; j < 3; j++) {
				this.matrice[i][j] = sol[i][j];	
			}
		}
	}
	
	public void verif(Block b) {
		Block[][] b_ok = b.craft.matrice;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				
			}
		}
	}
}

