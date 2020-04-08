import java.util.*;
import java.io.*;
public class E2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            String[] given = br.readLine().split(" ");
            int n = Integer.parseInt(given[0]);
            int x = Integer.parseInt(given[1]);
            int y = Integer.parseInt(given[2]);
            House[] ary = new House[n];
            for( int i = 0; i < n; i++) {
                given = br.readLine().split(" ");
                int d = Integer.parseInt(given[0]);
                int m = Integer.parseInt(given[1]);
                ary[i] = new House(i,d,m);
            }
            Arrays.sort(ary);
            int ans = -1;
            for( House h : ary ) {
                if( h.distance <= x && h.coins >= y ) {
                    ans = h.ind+1;
                    break;
                }
            }
            System.out.println(ans);
        }
    }
    public static class House implements Comparable<House> {
        int ind, distance, coins;
        public House(int ind, int distance, int coins) {
            this.ind = ind;
            this.distance = distance;
            this.coins = coins;
        }
        public int compareTo(House h) {
            if( h.distance == distance ) {
                if( h.coins == coins ) {
                    return ind - h.ind;
                } return h.coins - coins;
            } return distance - h.distance;
        } 
        public void print() {
            System.out.printf("%d %d %d\n", ind, distance, coins);
        }
    }
}