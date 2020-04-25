import java.util.*;
import java.io.*;
public class B {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n-->0) {
            int x = in.nextInt();
            if( (x/2)%2 == 0 ) {
                pw.println("YES");
                int[] ary = new int[x];
                int even = 2;
                int sum = 0;
                for( int i = 0; i < x/2; i++ ) {
                    ary[i] = even;
                    even += 2;
                    sum += ary[i];
                }
                int odd = 1;
                int sumOdd = 0;
                for( int i = x/2; i < x-1; i++ ) {
                    ary[i] = odd;
                    odd += 2;
                    sumOdd += ary[i];
                }
                ary[x-1] = sum-sumOdd;
                for( int i : ary ) pw.print(i+" ");
                pw.println();
            } else {
                pw.println("NO");
            }
        }
        pw.close();
    }
}