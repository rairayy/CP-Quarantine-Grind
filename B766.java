import java.util.*;

public class B766 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ary = new int[n];
        for( int i = 0; i < n; i++ ) ary[i] = in.nextInt();
        Arrays.sort(ary);
        boolean ans = false;
        for( int i = 0; i < n-2; i++ ) {
            ans = check(ary[i],ary[i+1],ary[i+2]);
            if(ans) break;
        }
        if(ans) System.out.println("YES");
        else System.out.println("NO");
    }
    static boolean check(long a, long b, long c) {
        if( a+b > c && a+c > b && b+c > a ) return true;
        return false;
    }
}