import java.util.*;
import java.io.*;
public class H {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			String[] inp = br.readLine().split(" ");
			int N = Integer.parseInt(inp[0]);
			int M = Integer.parseInt(inp[1]);
			int K = Integer.parseInt(inp[2]);
			String first = br.readLine();
			String sec = br.readLine();
			int[][] count = new int[sec.length()][26];
			count[0][sec.charAt(0)-'a']++;
			for( int i = 1; i < sec.length(); ++i ) {
				for( int j = 'a'; j <= 'z'; ++j ) {
					count[i][j-'a'] += count[i-1][j-'a'];
				}
				count[i][sec.charAt(i)-'a']++;
			}
			// pregenerate
			int[][] alph = new int[26][26];
			for( int i = 0; i < sec.length(); ++i ) {
				alph[sec.charAt(i)-'a'][sec.charAt(i)-'a']+=1;
				for( int j = 'a'; j <= 'z'; ++j ) {
					alph[sec.charAt(i)-'a'][j-'a']+=(count[sec.length()-1][j-'a']-count[i][j-'a']);
				}				
			}
			// System.out.println(Arrays.deepToString(alph));
			long ans = 0;
			for( int i = 0; i < first.length()-K+1	; ++i ) {
				ans += alph[first.charAt(i)-'a'][first.charAt(i+K-1)-'a'];
				alph[first.charAt(i)-'a'][first.charAt(i+K-1)-'a']=0;
			}
			pw.println(ans);
		}
		pw.close();
	}
}