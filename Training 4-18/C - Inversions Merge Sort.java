import java.util.*;
import java.io.*;
public class CMerge {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            String[] inp = br.readLine().split(" ");
            HashMap<String, Integer> hm = new HashMap<>();
            for( int i = 0; i < N; i++ ) hm.put(inp[i],i);
            inp = br.readLine().split(" ");
            int[] ary = new int[N];
            for( int i = 0; i < N; i++ ) ary[i] = hm.get(inp[i]);
            pw.println(sort(ary,0,N-1));
        }
        pw.close();
    }
    static long sort(int[] ary, int l, int r) {
        long inversions = 0L;
        if( l < r ) {
            int m = (l+r)/2;
            inversions += sort(ary,l,m);
            inversions += sort(ary,m+1,r);
            inversions += merge(ary,l,m,r);
        }
        return inversions;
    }
    static long merge(int[] ary, int l, int m, int r) {
        int[] L = Arrays.copyOfRange(ary, l, m+1);
        int[] R = Arrays.copyOfRange(ary, m+1, r+1);
        int leftInd = 0, rightInd = 0, ind = l;
        long inversions = 0;
        while( leftInd < L.length && rightInd < R.length ) {
            if( L[leftInd] <= R[rightInd] ) ary[ind++] = L[leftInd++];
            else {
                ary[ind++] = R[rightInd++];
                inversions += (m+1)-(l+leftInd);
                // both array fellows should be sorted at this point
                // if some fellow L[i] from the left side is greater than some fellow R[j] at the right side,
                //      an inversion happened
                // add the number of fellows from L[i+1] (i+1 => l+leftInd) to the midpoint (m+1)
            }
        }
        while( leftInd < L.length ) ary[ind++] = L[leftInd++];
        while( rightInd < R.length ) ary[ind++] = R[rightInd++];
        return inversions;
    }
}
