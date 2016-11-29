package bktree;
import java.util.ArrayList;

public class BurkhardKellerTree {

	
	private Node root;
	int dist = -1;
	private IDistanceCalculator calculator;
	
	//Factory will decide the distance that will be used
	public BurkhardKellerTree(IDistanceCalculator calculator, ArrayList<String> dictionary){
		this.calculator = calculator;
		
		for(int i =0; i<dictionary.size();i++){
			//System.out.println(dictionary.get(i));
			this.Add(dictionary.get(i));
		}
		//Initiates the tree with the dictionary
		/*for(String word : dictionary){
			//System.out.println("palavra: "+word);
			this.Add(word);
		}*/
		
	}

	//Change the method during execution - Can be deleted
	public void setCalculator(IDistanceCalculator distCalculator){
		this.calculator = distCalculator;
	}
	
	//
	public int calculateDistance(String first, String second){
		return calculator.calculateDistance(first, second);
	}
	
	public void Add(String word)
    {
        word = word.toLowerCase();
        if (root == null)
        {
            root = new Node(word);
            return;
        }
 
        Node curNode = root;
 
        //Padrão Strategy
        dist = calculateDistance(curNode.word, word);
        while (curNode.hasKey(dist))
        {
            if (dist == 0) return;
 
            curNode = curNode.get(dist);
            dist = calculateDistance(curNode.word, word);
        }
       // System.out.println("BKTree add");
        System.out.println(dist + " "+word+ " embaixo de " + curNode.word);
        curNode.AddChild(dist,word);
    }
	
	//My search method
	public ArrayList<String> Search(String word, int d)
    {
        ArrayList<String> rtn = new ArrayList<String>();
        word = word.toLowerCase();
 
        BurkhardKellerTreeSearchResult.RecursiveSearch(this, root, rtn, word, d); 
        return rtn;
    }
 
   
	//What to do in this search? What is i, j and string?
	public BurkhardKellerTreeSearchResult search(String string, int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

}
