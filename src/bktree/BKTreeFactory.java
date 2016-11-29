package bktree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class BKTreeFactory {
	
	private HashMap<String, IDistanceCalculator> calculatorPool = new HashMap<String, IDistanceCalculator>();
	
	private static BKTreeFactory instance = null;
	
	private BKTreeFactory(){
		
	}
	
	
	//defines which kind of calculations will be used
	//creates the tree based on the calculator type - the tree is the same for both
	public static BKTreeFactory getInstance(){
		if(instance == null)
			return new BKTreeFactory();
		return instance;
	}
	
	private IDistanceCalculator getCalculator(String calculationType){
		
		if(!calculatorPool.containsKey(calculationType)){
			if(calculationType.equals("Levenshtein"))
				calculatorPool.put(calculationType, new LevenshteinCalculator());
			else if(calculationType.equals("Demerau"))
				calculatorPool.put(calculationType, new DemerauLevenshteinCalculator());
		}
		return calculatorPool.get(calculationType);
	}
	
	public BurkhardKellerTree createBKTree(String calculationType){
		ArrayList<String> dictionary = null;
		try {
			dictionary = DictionaryReader.readDictionary();
		//	System.out.println("try");
		} catch (IOException e) {
			System.out.println("Error while reading the dictionary file");
			e.printStackTrace();
		}
		//System.out.println("before returning factory");
		return new BurkhardKellerTree(getCalculator(calculationType), dictionary);
	}

}
