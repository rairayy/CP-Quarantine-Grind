import java.util.*;

public class E {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-->0) {
            int S = in.nextInt();
            // build grid
            int[][] ary = new int[S][S];
            for( int i = 0; i < S; i++ ) {
                for( int j = 0; j < S; j++ ) {
                    ary[i][j] = in.nextInt();
                }
            }
            // bitmask
            // recursive mask then just check if it's valid at every step
        }
    }
    public static checkValidRow(int val) {

    }
}