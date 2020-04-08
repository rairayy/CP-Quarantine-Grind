import java.util.*;
import java.io.*;
// im dumb
public class A468 {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if( n <= 3 ) pw.println("NO");
        else if( n == 4 ) {
            pw.println("YES");
            pw.println("4 * 2 = 8\n8 * 3 = 24\n24 * 1 = 24");
        } else {
            pw.println("YES");
            pw.println("5 + 1 = 6");
            pw.println("6 * 4 = 24");
            if( n == 5 ) {
                pw.println("3 - 2 = 1");
                pw.println("24 * 1 = 24");
            } else {
                pw.println("3 * 2 = 6");
                pw.println("6 - 6 = 0");
                int ct = 7;
                while( ct <= n ) {
                    pw.printf("0 * %d = 0\n",ct);
                    ct++;
                }
                pw.println("0 + 24 = 24");
            }
        }
        pw.close();
    }
}