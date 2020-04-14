import java.util.*;
import java.io.*;
public class C1335 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            int[] ary = new int[N+1];
            String[] line = br.readLine().split(" ");
            int distinct = 0;
            int similar = 0;
            for( int i = 0; i < N; i++ ) {
                int temp = Integer.parseInt(line[i]);
                if( ary[temp] == 0 ) distinct++;
                ary[temp]++;
                similar = Math.max(ary[temp], similar);
            }
            System.out.println(Math.max(Math.min(similar-1,distinct),Math.min(similar,distinct-1)));
        }
    }
}