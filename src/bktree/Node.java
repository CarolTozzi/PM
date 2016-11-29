package bktree;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Node {

	public String word = null;
	public HashMap<Integer, Node> Children;

	public Node() { }

	public Node(String word)
	{
		this.word = word.toLowerCase();
	}

	public String getWord() {
		return this.word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public HashMap<Integer, Node> getChildren() {
		return Children;
	}

	public void setChildren(HashMap<Integer, Node> children) {
		Children = children;
	}	

	public Node get(int dist)
	{
		return this.Children.get(dist);
	}

	//retorna as keys do objeto children
	public Set<Integer> Keys()
	{
		if(Children == null)
			return new HashSet<Integer>();
		return Children.keySet();

	}
	
	public Set<Integer> distancesInRange(int min, int max){
		Set<Integer> keyRange = new HashSet<Integer>();
		
		for(int key : this.Keys()){			
			
			if((key <= min) && (key<=max))
				keyRange.add(key);
		
		}
		
		return keyRange;
	}

	public boolean hasKey(int key)
	{
		if(Children == null || Children.isEmpty())
			return false;
		else
			return Children.containsKey(key);
			
	}

	public void AddChild(int key, String word)
	{
		if(this.Children == null){
			//System.out.println("Sem filhos");
			Children = new HashMap<Integer, Node>();
			this.Children.put(key, new Node(word));
		}else{
			if(!this.Children.containsKey(key)){
				//System.out.println("Nao tem essa distancia");
				Children.put(key, new Node(word));
			}
			else{
				System.out.println("Cai no else");
				Children.get(key).AddChild(key, word);				
			}
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
