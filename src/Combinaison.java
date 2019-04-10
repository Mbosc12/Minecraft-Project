
public class Combinaison {

	public String[][] combi;
	public JFX_Grille jf;

	public Combinaison() {

		combi = new String [][] {
			{jf.blocks_aff.getId(),jf.b.getText(),jf.b.getText()},
			{jf.b.getText(),jf.b.getText(),jf.b.getText()},
			{jf.b.getText(),jf.b.getText(),jf.b.getText()}
		};

		combi = new String[][] {
			{jf.blocks_aff.getId().substring(6),jf.blocks_aff.getId().substring(6),jf.blocks_aff.getId().substring(6)},
			{jf.blocks_aff.getId().substring(6),jf.blocks_aff.getId().substring(6),jf.blocks_aff.getId().substring(6)},
			{jf.blocks_aff.getId().substring(6),jf.blocks_aff.getId().substring(6),jf.blocks_aff.getId().substring(6)}
		};



	}
}
