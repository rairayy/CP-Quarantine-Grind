import java.util.*;
import java.io.*;
public class L {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] ary = new int[n+1];
		while(n-->0) {
			String[] temp = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			for( int i = a; i <= b; i++ ) {
				ary[i]++;
			}
		}
		int ans = -1;
		for( int i = 1; i < ary.length; i++ ) {
			if( ary[i] == i ) ans = Math.max(ans, i);
		}
		System.out.println(ans);
		br.close();
	}
}