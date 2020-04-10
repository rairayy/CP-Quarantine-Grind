import java.util.*;

public class B463 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ary = new int[n+1];
        for( int i = 1; i <= n; i++ ) ary[i] = in.nextInt();
        int energy = 0;
        int add = 0;
        for( int i = 0; i < n; i++ ) {
            energy += ary[i]-ary[i+1];
            if( energy < 0 ) {
                add += Math.abs(energy);
                energy = 0;
            }
        }
        System.out.println(add);
    }
}