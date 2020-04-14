import java.io.*;
import java.util.*;

public class B492 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int L = Integer.parseInt(line[1]);
        line = br.readLine().split(" ");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for( String s : line ) pq.add(Integer.parseInt(s));
        double max = -1.0;
        if(pq.peek()!=0) max = pq.peek();
        while(!pq.isEmpty()) {
            int curr = pq.poll();
            if( pq.isEmpty() ) {
                if( curr != L ) max = Math.max(max,L-curr);
            } else {
                max = Math.max(max, (pq.peek()-curr)/2.0);
            }
        }
        System.out.printf("%.10f\n",max);
    }
}