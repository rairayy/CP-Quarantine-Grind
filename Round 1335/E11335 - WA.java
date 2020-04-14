import java.util.*;

public class E11335 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-->0) {
            int N = in.nextInt();
            int[] ary = new int[N];
            for( int i = 0; i < N; i++ ) ary[i] = in.nextInt();
            int max = Integer.MIN_VALUE;
            for( int i = 0; i < N; i++ ) {
                int end = N-1;
                int start = i;
                int ct = 0;
                int[] memo = new int[27];
                int distinct = 0;
                while(end>=start) {
                    if( ary[start] != ary[end] ) end--;
                    else {
                        if( start == end ) {
                            ct++; break;
                        }
                        if( memo[ary[start]]==0 ) {
                            distinct++;
                            if( distinct > 2 ) break;
                        }
                        memo[ary[start]]++;
                        ct+=2;
                        start++;
                        end--;
                    }
                }
                if(distinct <= 2) max = Math.max(ct,max);
            }
            System.out.println(max);
        }
    }
}