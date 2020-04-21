import java.util.*;

public class B79 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String[][] ary = new String[n][m];
        int w = in.nextInt();
        int q = in.nextInt();
        while(w-->0) {
            int r = in.nextInt()-1;
            int c = in.nextInt()-1;
            ary[r][c] = "Waste";        
        }
        String[] F = {"Carrots","Kiwis","Grapes"};
        int ind = 0;
        for( int i = 0; i < n; i++ ) {
            for( int j = 0; j < m; j++ ) {
                if( ary[i][j] == null ) {
                    ary[i][j] = F[ind%3];
                    ind++;
                }
            }
        }
        while(q-->0) System.out.println(ary[in.nextInt()-1][in.nextInt()-1]);
    }
}