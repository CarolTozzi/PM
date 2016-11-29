package bktree;

public class Main {

	public static void main(String[] args) {
		
		BKTreeFactory factory = BKTreeFactory.getInstance();
		
		BurkhardKellerTree tree = factory.createBKTree("Levenshtein");
		
		//System.out.println(tree.calculateDistance("casa", "carro"));

		System.out.println(tree.calculateDistance("ABACATE", "ABACATEIRO"));
		//tree.search("casa", 1, 0);
		
	}

}
