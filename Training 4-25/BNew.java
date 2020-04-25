import java.util.*;
import java.io.*;
public class BNew {
    public static void main(String[] args) throws Exception {
        File file = new File("task.in");
        BufferedReader br = new BufferedReader(new FileReader(file));
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            String[] inp = br.readLine().split(" ");
            int[] ary = new int[N];
            for( int i = 0; i < N; i++ ) {
                ary[i] = Integer.parseInt(inp[i]);
            }
            Arrays.sort(ary);
            long missing = 0;
            int prev = 0;
            for( int i = 0; i < N; i++ ) {
                missing += ary[i]-prev-1;
                prev = ary[i];
            }
            long total = 0;
            int ary_length = N;
            prev = 0;
            for( int i = 0; i < N; i++ ) {
                if( (long) ary[i]-prev > 1 ) {
                    if( (long) (missing-(ary[i]-prev-1))+(ary[i]-prev-1) < N-i ) {
                        total += (long) (ary[i]-prev)-1;
                        ary_length += (long) (ary[i]-prev)-1;
                        missing += (long) (ary[i]-prev)-1;
                    } else {
                        total += (long) N-i;
                        ary_length -= (long) N-i;
                        break;
                    }
                } else if( ary[i] == prev ) {
                    total++;
                    ary_length--;
                }
                prev = ary[i];
                // System.out.println(total);
            }
            if(ary_length == 0) total++;
            System.out.println(total);
        }
    }
}