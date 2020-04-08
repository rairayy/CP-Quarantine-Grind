import java.util.*;

public class A381 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ary = new int[n];
        for( int i = 0; i < n; i++ ) ary[i] = in.nextInt();
        int l = 0, r = n-1;
        int s = 0, d = 0;
        boolean s_turn = true;
        while(l<=r) {
            int add = 0;
            if( ary[l] > ary[r] ) {
                add = ary[l];
                l++;
            } else {
                add = ary[r];
                r--;
            }
            if(s_turn) {
                s += add;
                s_turn = false;
            } else {
                d += add;
                s_turn = true;
            }
        }
        System.out.printf("%d %d",s,d);
    }
}