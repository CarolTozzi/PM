package bktree;

public class DemerauLevenshteinCalculator implements IDistanceCalculator{

	public int calculateDistance(String first, String second)
    {
		
			//If both strings are empty, I'm of the opinion that
			//this is an error (technically the distance is zero).
			assert( !(first.isEmpty() && second.isEmpty()));
			
			//If the first string is empty, the distance is the
			//length of the second string.
			if(first.isEmpty()){
				return second.length();
			}
			
			//If the second string is empty, the distance is the
			//length of the first string.
			if(second.isEmpty()){
				return first.length();
			
			}
			//Delegate the calculation to the method that produces the matrix
			//and distance, but then only return the distance
		return calculateAndReturnFullResult(first, second).getDistance();
	}
		
	
		public DameauLevenshteinDistanceResult calculateAndReturnFullResult(String first, String second){
			//If both strings are empty, I'm of the opinion that
			//this is an error (technically the distance is zero).
			assert( !(first.isEmpty() && second.isEmpty()));
			
			//We are going to construct a matrix of distances
			int[][] distanceMatrix = new int[first.length() + 1][second.length() + 1];
			
			//We need indexers from 0 to the length of the first string.
			//This sequential set of numbers will be the row "headers"
			//in the matrix.
			for(int firstIndex = 0; 
				firstIndex <= first.length(); 
				firstIndex++){
				
				//Set the value of the first cell in the row
				//equivalent to the current value of the iterator
				distanceMatrix[firstIndex][0] = firstIndex;	
			}
			
			//We need indexers from 0 to the length of the second string.
			//This sequential set of numbers will be the column "headers"
			//in the matrix.
			for(int secondIndex = 0;
				secondIndex <= second.length();
				secondIndex++){
				
				//Set the value of the first cell in the column
				//equivalent to the current value of the iterator
				distanceMatrix[0][secondIndex] = secondIndex;
			}
			
			//We'll use this to add a penalty
			//to some operations.
			int cost = 0;
			
			//Iterate over all characters in the first
			//string.
			for(int firstIndex = 1; 
			firstIndex <= first.length(); 
			firstIndex++){
				
				//Iterate over all characters in the second
				//string.
				for(int secondIndex = 1;
				secondIndex <= second.length();
				secondIndex++){
					
					//If the current characters in both strings are equal
					if(first.charAt(firstIndex - 1) == second.charAt(secondIndex - 1))
					{
						//There is no penalty.
						cost = 0;
					}
					else 
					{
						//Not equal, there is a penalty.
						cost = 1;
					}
					
					//We want to find the current distance by determining
					//the shortest path to a match (hence the 'minimum'
					//calculation on distances).
					distanceMatrix[firstIndex][secondIndex] = minimum(distanceMatrix[firstIndex - 1][secondIndex] + 1, distanceMatrix[firstIndex][secondIndex - 1] + 1,distanceMatrix[firstIndex - 1][secondIndex - 1] + cost);
					      	//Character match between current character in 
					        //first string and next character in second
					    	//Character match between next character in
					    	//first string and current character in second
					    	
					    	//No match, at current, add cumulative penalty
					    	
					
					//We don't want to do the next series of calculations on
					//the first pass because we would get an index out of bounds
					//exception.
					if(firstIndex == 1 || secondIndex == 1){
						continue;
					}
					
					//transposition check (if the current and previous character are
					//switched around (e.g.: t[se]t and t[es]t)...
					if(  first.charAt(firstIndex - 1) == second.charAt(secondIndex - 2)
					  && first.charAt(firstIndex - 2) == second.charAt(secondIndex - 1)){
						
						//What's the minimum cost between the current distance
						//and a transposition.
						distanceMatrix[firstIndex][secondIndex] 
						  = Math.min(
						     //Current cost
							 distanceMatrix[firstIndex][secondIndex],
							 //Transposition
							 distanceMatrix[firstIndex - 2][secondIndex - 2] + cost);
					}
				}
			}
			
			//Return the matrix and distance as the result
			return new DameauLevenshteinDistanceResult(distanceMatrix);
		}
		
	
		private static int minimum(int... values){
			
			//Hopefully, everything should be smaller
			//than the max integer value!
			int currentMinimum = Integer.MAX_VALUE;
			
			//Iterate over all provided values
			for(int value : values){
				
				//Take the minimum value between the current
				//minimum and the current value of the
				//iteration
				currentMinimum = Math.min(value, currentMinimum);
			}
			
			//return the minimum value.
			return currentMinimum;
		}
		
		
		public class DameauLevenshteinDistanceResult {
			
			//Distance matrix
			private int[][] distanceMatrix;
			
			/**
			 * Instantiate the object with the resulting distance matrix
			 * @param distanceMatrix Matrix of distances between edits
			 */
			public DameauLevenshteinDistanceResult(int[][] distanceMatrix){
				this.distanceMatrix = distanceMatrix;
			}

			/**
			 * Get the Distance Matrix
			 * @return Matrix of edit distances
			 */
			public int[][] getDistanceMatrix() {
				return distanceMatrix;
			}
			
			/**
			 * Get the Edit Distance
			 * @return number of changes to make before
			 *         both strings are identical
			 */
			public int getDistance(){
				return 
					distanceMatrix[distanceMatrix.length - 1][distanceMatrix[0].length - 1];
			}

			/**
			 * Get a string representation of this class
			 * @return A friendly display of the distance and matrix
			 */
			@Override
			public String toString() {
				
				StringBuilder sb = new StringBuilder();
				
				sb.append(String.format("Distance: %s \n", this.getDistance()));
				sb.append("Matrix: \n\n");
				
				for(int i = 0; i < this.distanceMatrix.length; i++){
					
					sb.append("| ");
					
					for(int j = 0; j < this.distanceMatrix[0].length; j++){
					
						sb.append(String.format("\t%s", this.distanceMatrix[i][j]));
					}
					
					sb.append(" |\n");
				}
				
				return sb.toString();
			}
		}
		
    }
	


