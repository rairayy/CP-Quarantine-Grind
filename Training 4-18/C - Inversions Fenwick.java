import java.util.*;
import java.io.*;
public class CFenwick {
    static int n = 100000;
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
            long inversions = 0;
            long[] fen = new long[n+1];
            for( int i : ary ) {
                inversions += sum(fen,i+1,n-1);
                add(fen,i,1);
                // System.out.println(sum(fen,i,n-1));
            }
            System.out.println(inversions);
        }
        pw.close();
    }
    static void add(long[] fen, int i, long v) {
        for(++i; i <= n; i+= i & -i) fen[i] += v;
    }
    static long sum(long[] fen, int i) {
        long S = 0;
        for(++i; i > 0; i -= i & -i) S += fen[i];
        return S;
    }
    static long sum(long[] fen, int a, int b) {
        return sum(fen,b) - sum(fen,a-1);
    }
}