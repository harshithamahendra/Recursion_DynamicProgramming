/*
 * The distinct paths for the mountain climb given N can be calculated as 2^(N-1) since each climb can 
 * be reached in two possible ways from the previous climb. 
 * Dynamic programming is used to calculate the distinct paths with traps
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MountainClimb {
	static int[][] mountiain;
	static int N;			
	static int distinctPaths1;
	static int distinctPaths2;
	
	static List<String> mountains = new ArrayList<String>(); 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter the size of the mountain");
		N = Integer.parseInt(br.readLine());
		distinctPaths1 = pathsWithoutTraps(N);
		System.out.println("Number of distinct paths: " + distinctPaths1);
		System.out.println("Enter the paths to the mountain with traps");
		for(int i = 0; i < N;i++)
			mountains.add(br.readLine());
		distinctPaths2 = pathsWithTraps(mountains);
		System.out.println("Number of distinct paths with traps: " + distinctPaths2);
		
	}
	/*
	 * returns the Distinct paths to climb the mountain without obstacles
	 */
	public static int pathsWithoutTraps(int N){
		return (int)Math.pow(2,N - 1);
	}
	/*
	 * returns distinct paths with the traps
	 * Uses dynamic programming to calculate the paths at each level based on the number of paths from the level below.
	 */
	public static int pathsWithTraps(List<String> mountain){
		int[][] array = new int[mountain.size()][mountain.size()];	/*Array to calculate the number of distinct paths at each level*/
		char[] temp;		/*Holds the characters of each input line*/
		//Initialize the last row of the array to 1 except for the traps which is initialized to 0
		temp = mountain.get(mountain.size() - 1).toCharArray();
		for(int i = 0;i < temp.length;i++){
			if(temp[i] == 'O')
				array[mountain.size() - 1][i] = 1;
		}
		// Path at each climb is calculated using the number of climbs at the left and right diagonals below 
		for(int i = mountain.size() - 2; i >= 0;i--){
			temp = mountain.get(i).toCharArray();
			for(int j = 0;j < temp.length;j++){
				if(temp[j] == 'O')
					array[i][j] = array[i + 1][j] + array[i + 1][j + 1];
			}
		}
		return array[0][0];
	}
}
