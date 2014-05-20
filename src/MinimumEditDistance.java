/*
 * Given a source and a destination string, find the minimum edit operations required to transform the source to 
 * the destination
 */
import java.io.*;
public class MinimumEditDistance {
	public static void main(String[] args) throws IOException{
		char[] str1, str2;
		int minimum_edit_distance;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the source word");
		str1 = br.readLine().toCharArray();
		System.out.println("Enter the destination word");
		str2 = br.readLine().toCharArray();
		minimum_edit_distance = MED(str1, str2);
		System.out.println("The minimum edit distance is " + minimum_edit_distance);
	}
	/*
	 * returns the minimum edit distance from source to destination
	 */
	public static int MED(char[] source, char[] dest){
		int[][] dist = new int [source.length + 1][dest.length + 1];
		//initialization
		dist[source.length][0] = 0;
		// initialize first column
		for(int i = source.length - 1;i >= 0;i--)
			dist[i][0] = 1 + dist[i + 1][0]; 
		//initialize last row 
		for(int j = 1;j <= dest.length;j++)
			dist[source.length][j] = 1 + dist[source.length][j - 1];
		//populate the distance array
		for(int i = source.length - 1;i >= 0;i--){
			for(int j = 1; j <= dest.length;j++){
				if(source[source.length - 1 - i] == dest[j - 1])
					dist[i][j] = dist[i + 1][j - 1];	//if a match is found the MED is 0.
				else
					dist[i][j] = Math.min(Math.min(dist[i + 1][j] + 1, 			//delete operation
													dist[i][ j - 1] + 1),		//insert operation
													dist[i + 1][j - 1] + 2);	//substitution
			}
		}
		return dist[0][dest.length];
	}
}
