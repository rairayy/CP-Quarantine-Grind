import java.util.*;

public class B680 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt()-1;
        int[] ary = new int[n];
        for( int i = 0; i < n; i++ ) ary[i] = in.nextInt();
        int l = a, r = a;
        int capture = 0;
        while( l >= 0 || r < n ) {
            int valid = 0;
            int detected = 0;
            if( l >= 0 ) {
                valid++;
                if( ary[l] == 1 ) detected++;
            }
            if( l != r && r < n ) {
                valid++;
                if( ary[r] == 1 ) detected++;
            }
            // System.out.printf("%d %d\n", valid, detected);
            if( valid <= detected )  capture += detected;
            r++; l--;
        }
        System.out.println(capture);
    }
}