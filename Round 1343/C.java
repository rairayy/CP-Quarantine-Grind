import java.util.*;
import java.io.*;
public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            String[] inp = br.readLine().split(" ");
            int[] ary = new int[N];
            for( int i = 0; i < N; i++ ) ary[i] = Integer.parseInt(inp[i]);
            long max = ary[0];
            int prevAdded = ary[0];
            boolean prevNeg = false;
            if( ary[0] < 0 ) prevNeg = true;
            for( int i = 1; i < N; i++ ) {
                if( ary[i] < 0 ) {
                    if( prevNeg ) {
                        if( max-prevAdded+ary[i] > max ) {
                            max -= prevAdded;
                            max += ary[i];
                            prevAdded = ary[i];
                        }
                    } else {
                        max += ary[i];
                        prevAdded = ary[i];
                        prevNeg = true;
                    }
                } else {
                    if( prevNeg ) {
                        max += ary[i];
                        prevAdded = ary[i];
                        prevNeg = false;
                    } else {
                        if( max-prevAdded+ary[i] > max ) {
                            max -= prevAdded;
                            max += ary[i];
                            prevAdded = ary[i];
                        }
                        
                    }
                }
                // System.out.println(max);
            }
            System.out.println(max);
        }
    }
}