import java.util.*;

public class BrokenCalc {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int display = in.nextInt();
        int target = in.nextInt();
        System.out.println(brokenCalc(display,target));
    }
    // brokenCalc function assumes that if X <= 0, then Y <= X
    public static int brokenCalc(int X, int Y) {
        int ctr = 0;
        // reverse the problem
        if( X > 0 ) { // for cases where X > 0
            while( Y > X ) {
                if( Y%2 == 0 ) Y /= 2;  // divide by 2 if Y is even
                else Y++;               // add 1 if Y is odd
                ctr++;
            }
        } else { // for cases where X <= 0
            while( Y != X ) {
                if( Y%2 == 0 ) Y /= 2;  // divide by 2 if Y is even
                else Y++;               // add 1 if Y is odd
                ctr++;
            }
        }
        return ctr+(X-Y);
    }
}