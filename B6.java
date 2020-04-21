import java.util.*;

public class B6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        char pres = in.nextLine().charAt(1); 
        TreeSet<Character> ts = new TreeSet<>();
        char[][] ary = new char[n+2][m+2];
        for( char[] c : ary ) {
            Arrays.fill(c,'.');
        }
        for( int i = 1; i <= n; i++ ) {
            String ln = in.nextLine();
            for( int j = 1; j <= m; j++ ) ary[i][j] = ln.charAt(j-1);
        }
        for( int i = 1; i <= n; i++ ) {
            for( int j = 1; j <= m; j++ ) {
                if( ary[i][j] == pres ) {
                    for( int di = -1; di <= 1; di++ ) {
                        for( int dj = -1; dj <= 1; dj++ ) {
                            if( di*dj == 0 && di != dj && ary[i+di][j+dj] != pres && ary[i+di][j+dj] != '.') ts.add(ary[i+di][j+dj]);
                        }
                    }
                }
            }
        }
        System.out.println(ts.size());
    }
}