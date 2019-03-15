
public class Craft {

	public int res;
	public Integer[][] matrice;
	
	
	public Craft(int r) {
		
		this.matrice = new Integer[][] {
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0}
		};
		
		this.res = r;
	}
	
	
	public void setCraft(String l1, String l2, String l3) {
	
		String[] s = {l1, l2, l3};
		
		for(int i=0; i < 3; i++) {
			for(int j=0; j < 3; j++) {
				if (s[i].charAt(j) == '#') {
					this.matrice[i][j] = 1; 	
				}
			}
		}
	}
	
	public void setElement(int pos1, int pos2, Block b) {
		if(matrice[pos1][pos2] == 1) {
			matrice[pos1][pos2] = b.ID;
		}
		
	}
	
	
	
}
