
public class Combinaison {
	
	String[][] matrice;
	
	public Combinaison() {

		matrice = new String[][] {
				{"vide","vide","vide"},
				{"vide","vide","vide"},
				{"vide","vide","vide"}
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
