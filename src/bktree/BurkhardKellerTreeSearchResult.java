package bktree;

import java.util.ArrayList;

public class BurkhardKellerTreeSearchResult {


	public Object getWord(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	public double getDistance(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void RecursiveSearch(BurkhardKellerTree bkTree, Node node, ArrayList<String> rtn, String word, int d )
	{
		int curDist = bkTree.calculateDistance(node.word, word);
		int minDist = curDist - d;
		int maxDist = curDist + d;

		if (curDist <= d)
			rtn.add(node.word);

		for(int key : node.distancesInRange(minDist, maxDist))
		{
			RecursiveSearch(bkTree, node.get(key), rtn, word, d);
		}
	}

}
