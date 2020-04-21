import java.util.*;
import java.io.*;
public class B433 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] ary = new int[N+1];
        for( int i = 0; i < N; i++ ) ary[i+1] = Integer.parseInt(line[i]);
        long[] unsorted = new long[N+1];
        for( int i = 0; i < N; i++ ) unsorted[i+1] = (long) ary[i+1]+unsorted[i];
        Arrays.sort(ary);
        long[] sorted = new long[N+1];
        for( int i = 0; i < N; i++ ) sorted[i+1] = (long) ary[i+1]+sorted[i];
        int Q = Integer.parseInt(br.readLine());
        while(Q-->0) {
            line = br.readLine().split(" ");
            int op = Integer.parseInt(line[0]);
            int L = Integer.parseInt(line[1]);
            int R = Integer.parseInt(line[2]);
            if(op==1) System.out.println(unsorted[R]-unsorted[L-1]);
            else System.out.println(sorted[R]-sorted[L-1]);
        }
    }   
}