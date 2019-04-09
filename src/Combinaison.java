
public class Combinaison {

	Repertoire r = new Repertoire();
	
	String[][] matrice;
	
	public Combinaison() {
		
		matrice = new String[][] {
				{"test","test","test"},
				{"test","test","test"},
				{"test","test","test"}
		};
		
	}
	
	public boolean verification(Item[][] i) {
		for(int a = 0; a < 9; a++) {
			if(!(i[a/3][a%3].libelle.equals(this.matrice[a/3][a%3]))) {
				return false;
			}
		}
		return true;
		
	}
}