import java.io.*;
public class G {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			String[] inp = br.readLine().split(" ");
			int N = Integer.parseInt(inp[0]);
			int M = Integer.parseInt(inp[1]);
			int[][] ary = new int[N][M];
			for( int i = 0; i < N; i++ ) {
				inp = br.readLine().split(" ");
				for( int j = 0; j < M; j++ ) ary[i][j] = Integer.parseInt(inp[j]);
			}
			int[][] UL = new int[N][M];
			int[][] UR = new int[N][M];
			int[][] LL = new int[N][M];
			int[][] LR = new int[N][M];
			int[][] leftRight = new int[N][M];
			int[][] rightLeft = new int[N][M];
			for( int i = 0; i < N; i++ ) {
				int rowMax = Integer.MIN_VALUE;
				for( int j = 0; j < M; j++ ) {
					rowMax = Math.max(rowMax,ary[i][j]);
					leftRight[i][j] = rowMax;
				}
			}
			for( int i = N-1; i >= 0; i-- ) {
				int rowMax = Integer.MIN_VALUE;
				for( int j = M-1; j >= 0 ; j-- ) {
					rowMax = Math.max(rowMax,ary[i][j]);
					rightLeft[i][j] = rowMax;
				}
			}
			// sweeping down
			for( int i = 0; i < M; i++ ) {
				int colMaxL = Integer.MIN_VALUE;
				int colMaxR = Integer.MIN_VALUE;
				for( int j = 0; j < N; j++ ) {
					colMaxL = Math.max(colMaxL,leftRight[j][i]);
					colMaxR = Math.max(colMaxR,rightLeft[j][i]);
					UL[j][i] = colMaxL;
					UR[j][i] = colMaxR;
				}
			}
			// sweeping up
			for( int i = M-1; i >= 0; i-- ) {
				int colMaxL = Integer.MIN_VALUE;
				int colMaxR = Integer.MIN_VALUE;
				for( int j = N-1; j >= 0; j-- ) {
					colMaxL = Math.max(colMaxL,leftRight[j][i]);
					colMaxR = Math.max(colMaxR,rightLeft[j][i]);
					LL[j][i] = colMaxL;
					LR[j][i] = colMaxR;
				}
			}
			// for( int[] a : LR ) System.out.println(Arrays.toString(a));
			// System.out.println();
			int minDiff = Integer.MAX_VALUE;
			for( int i = 1; i < N-1; i++ ) {
				for( int j = 1; j < M-1; j++ ) {
					int ul = UL[i-1][j-1];
					int ur = UR[i-1][j+1];
					int ll = LL[i+1][j-1];
					int lr = LR[i+1][j+1];
					// System.out.printf("%d: %d %d %d %d\n",ary[i][j],ul,ur,ll,lr);
					minDiff = Math.min(minDiff,Math.max(ul,Math.max(ur,Math.max(ll,lr)))-Math.min(ul,Math.min(ur,Math.min(ll,lr))));
				}
			}
			pw.println(minDiff);
		}
		pw.close();
	}
}