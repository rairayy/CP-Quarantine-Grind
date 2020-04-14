import java.util.*;
import java.io.*;
public class D1335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            String[][] ary = new String[9][9];
            for( int i = 0; i < 9; i++ ) {
                String ln = br.readLine();
                for( int j = 0; j < 9; j++ ) {
                    ary[i][j] = ln.charAt(j)+"";
                }
            }
            ary[0][0] = ary[1][0];
            ary[3][1] = ary[4][1];
            ary[6][2] = ary[7][2];
            ary[1][3] = ary[2][3];
            ary[4][4] = ary[5][4];
            ary[7][5] = ary[8][5];
            ary[2][6] = ary[1][6];
            ary[5][7] = ary[4][7];
            ary[8][8] = ary[7][8];
            for( String[] s : ary ) {
                for( String ss : s ) {
                    pw.print(ss);
                }
                pw.println();
            }
        }
        pw.flush();
    }
}