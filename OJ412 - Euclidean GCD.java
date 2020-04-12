import java.util.*;
import java.io.*;
public class OJ412 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if( n == 0 ) break;
            int[] ary = new int[n];
            for( int i = 0; i < n; i++ ) ary[i] = Integer.parseInt(br.readLine());
            int ct = 0;
            for( int i = 0; i < n; i++ ) {
                for( int j = i+1; j < n; j++ ) {
                    if( gcd(ary[i],ary[j]) == 1 ) ct++;
                }
            }
            if(ct>0) System.out.printf("%.6f\n",Math.sqrt((double)chooseTwo(n)/(ct/6.0)));
            else System.out.println("No estimate for this data set.");
        }
    }
    static int gcd(int a, int b) {
        if( b == 0 ) return a;
        return gcd(b,a%b);
    }
    static int chooseTwo(int n) {
        return n*(n-1)/2;
    }
}