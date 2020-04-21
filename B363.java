import java.util.*;

public class B363 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt()-1;
        int[] ary = new int[n+1];
        for( int i = 1; i <= n; i++ ) ary[i] = in.nextInt();
        int[] sums = new int[n+1];
        for( int i = 1; i <= n; i++ ) sums[i] = sums[i-1]+ary[i];
        int min = Integer.MAX_VALUE;
        int ind = 0;
        for( int i = 1; i <= n-k ; i++ ) {
            if( sums[i+k]-sums[i-1] < min ) {
                min = sums[i+k]-sums[i-1];
                ind = i;
            }
        }
        System.out.println(ind);
    }
}