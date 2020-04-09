import java.util.*;

public class B66 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ary = new int[n];
        for( int i = 0; i < n; i++ ) ary[i] = in.nextInt();
        int l = 0, r = 0;
        int max = Integer.MIN_VALUE;
        for( int i = 0; i < n; i++ ) {
            l = i-1;
            r = i+1;
            int ct = 1;
            while( l >= 0 && ary[l] <= ary[l+1] ) {
                ct++; l--;
            }
            while( r < n && ary[r] <= ary[r-1] ) {
                ct++; r++;
            }
            // System.out.printf("%d %d\n",l,r);
            max = Math.max(ct,max);
        }
        System.out.println(max);
    }
}