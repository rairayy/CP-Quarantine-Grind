import java.util.*;

public class B79 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int w = in.nextInt();
        int q = in.nextInt();
        Waste[] waste = new Waste[w];
        for( int i = 0; i < w; i++ ) {
            int r = in.nextInt();
            int c = in.nextInt();
            waste[i] = new Waste(r,c);   
        }
        Arrays.sort(waste);
        // for(Waste wa : waste) wa.print();
        String[] F = {"Carrots","Kiwis","Grapes"};
        while(q-->0) {
            int r = in.nextInt();
            int c = in.nextInt();
            int wasteCt = 0;
            String ans = "?";
            for( Waste wa : waste ) {
                // System.out.printf("%d %d: %d %d\n",r,c,wa.r,wa.c);
                if( wa.r == r && wa.c == c ) {
                    ans = "Waste";
                    break;
                } else if( wa.r >= r && wa.c >= c ) {
                    ans = F[((((r-1)*m)+(c-1))-wasteCt)%3];
                    break;
                } else if( wa.r > r ) {
                    ans = F[((((r-1)*m)+(c-1))-wasteCt)%3];
                    break;
                }
                wasteCt++;
            }
            if( ans.equals("?") ) ans = F[((((r-1)*m)+(c-1))-wasteCt)%3];
            System.out.println(ans);
        }
    }
    static class Waste implements Comparable<Waste>{
        int r, c;
        public Waste(int r, int c) {
            this.r = r;
            this.c = c;
        }
        public int compareTo(Waste w) {
            if( r == w.r ) return c - w.c;
            return r - w.r;
        }
        public void print() {
            System.out.printf("w: %d %d\n",r,c);
        }
    }
}