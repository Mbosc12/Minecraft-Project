import java.util.Scanner;

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
	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		Combinaison b = new Combinaison();

		for(int i = 0; i < 9; i++) {
			System.out.println("Entrez le block que vous voulez mettre à la place :" + i);
	    	b.matrice[i/3][i%3] = myObj.nextLine();
	    }
	    
		System.out.println(b.verification(b.r.rep.get(10).craft.matrice));
	}

}
