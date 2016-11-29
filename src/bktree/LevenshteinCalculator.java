package bktree;

public class LevenshteinCalculator implements IDistanceCalculator{
	
	//change this method
	public int calculateDistance(String first, String second)
    {
        if (first.length() == 0) return second.length();
        if (second.length() == 0) return first.length();
 
        int lenFirst = first.length();
        int lenSecond = second.length();
        
        char[] firstWord = first.toCharArray();
        char[] secondWord = second.toCharArray();
 
        int [][] d = new int[lenFirst + 1][ lenSecond + 1];
 
        for (int i = 0; i <= lenFirst; i++)
            d[i][0] = i;
 
        for (int i = 0; i <= lenSecond; i++)
            d[0][i] = i;
 
        for (int i = 1; i <= lenFirst; i++)
        {
            for (int j = 1; j <= lenSecond; j++)
            {
                int match = (firstWord[i - 1] == secondWord[j - 1]) ? 0 : 1;
 
                d[i][j] = Math.min(Math.min(d[i - 1][j] + 1, d[i][j - 1] + 1), d[i - 1][j - 1] + match);
            }
        }
 
        return d[lenFirst][lenSecond];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LevenshteinCalculator levi = new LevenshteinCalculator();
		System.out.println(levi.calculateDistance("ABACATE", "ABACATEIRO"));
	}

}
