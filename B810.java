import java.util.*;

public class B810 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int f = in.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        long ans = 0;
        while(n-->0) {
            int k = in.nextInt();
            int l = in.nextInt();
            ans += Math.min(k,l);
            pq.add(Math.min(k*2,l)-Math.min(k,l));
        }
        while(f-->0) ans += pq.remove();
        System.out.println(ans);
    }
}