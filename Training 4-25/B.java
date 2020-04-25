import java.util.*;
import java.io.*;
public class B {
    public static void main(String[] args) throws Exception {
        File file = new File("task.in");
        BufferedReader br = new BufferedReader(new FileReader(file));
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            String[] inp = br.readLine().split(" ");
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            long total = 0L;
            long ary_length = N;
            for( int i = 0; i < N; i++ ) {
                int temp = Integer.parseInt(inp[i]);
                if( temp <= N ) pq.add(temp); 
                else { total++; ary_length--; }
            }
            int prev = 0;
            int i = 0;
            int len = pq.size();
            while(!pq.isEmpty()) {
                int temp = pq.remove();
                if( (long) temp-prev > 1 ) {
                    if( (long) temp-prev-1 < len-i ) {
                        total += (long) temp-prev-1;
                        ary_length += (long) temp-prev-1;
                    } else {
                        total += (long) len-i;
                        ary_length -= (long) len-i;
                        break;
                    }
                } else if( temp == prev ) {
                    total++;
                    ary_length--;
                }
                prev = temp;
                i++;
                // System.out.println(total);
            }
            if( ary_length == 0 ) total++;
            System.out.println(total);
        }
    }
}