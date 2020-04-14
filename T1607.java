import java.util.*;

public class T1607 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        int dp = in.nextInt();
        int t = in.nextInt();
        int dt = in.nextInt();
        boolean turn = true; // true if petr's turn
        int ans = 0;
        while(true) {
            if( turn ) { // petr
                if( p >= t ) {
                    ans = p;
                    break;
                }
                if( t <= p-dp ) {
                    ans = t;
                    break;
                }
                if( t <= p+dp ) {
                    ans = t;
                    break;
                }
                p += dp;
            } else { // taxi
                if( p >= t-dt ) {
                    ans = p;
                    break;
                }
                if( p >= t+dt ) {
                    ans = p;
                    break;
                }
                t -= dt;
            }
            turn = !turn;
        }
        System.out.println(ans);
    }
}