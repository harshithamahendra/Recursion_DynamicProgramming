/*
 * Given an NxN matrix, compute the number of paths to reach the bottom right from top left of the array
 * with constraint that you can only move to right or down from each cell.
 */
import java.io.*;
public class NxNPaths {
	static int N, paths;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the value for N");
		N = Integer.parseInt(br.readLine());
		paths = findPaths(N);
		System.out.println("Number of paths to reach the bottom right of the array from top left is " + paths);
	}
	public static int findPaths(int N){
		if(N == 1)
			return 0;
		int[][] array = new int[N][N];
		//Number of paths to reach the first row is 1
		for(int i = 0;i < N;i++)
			array[i][0] = 1;
		//Number of paths to reach the first column is 1
		for(int i = 0;i < N;i++)
			array[0][i] = 1;
		for(int i = 1;i < N;i++){
			for(int j = 1;j < N;j++){
				array[i][j] = array[i - 1][j] + array[i][j - 1];
			}
		}
		return array[N - 1][N - 1];
	}
}
