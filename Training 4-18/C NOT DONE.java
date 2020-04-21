import java.util.*;
import java.io.*;
public class C {
    // C is for Cisco !!!
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
            // System.out.println(Arrays.toString(ary));
            pw.println(sort(ary,0,N-1));
            // System.out.println(Arrays.toString(ary));
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
        Queue<Integer> left = new LinkedList<>();
        Queue<Integer> right = new LinkedList<>();
        // System.out.printf("%d %d %d\n",l,m,r);
        for( int i = l; i <= m; i++ ) left.add(ary[i]);
        for( int i = m+1; i <= r; i++ ) right.add(ary[i]);
        int k = l, leftInd = l, inversions = 0;
        while( !left.isEmpty() && !right.isEmpty() ) {
            if( left.peek() < right.peek() ) {
                ary[k] = left.remove();
                leftInd++;
            } else {
                ary[k] = right.remove();
                inversions += (m+1)-leftInd;
            }
            k++;
        }
        while(!left.isEmpty()) {
            ary[k] = left.remove();
            k++;
        }
        while(!right.isEmpty()) {
            ary[k] = right.remove();
            k++;
        }
        return inversions;
    }
}
