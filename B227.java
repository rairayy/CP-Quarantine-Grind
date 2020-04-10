import java.util.*;

public class B227 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for( int i = 1; i <= n; i++ ) hm.put(in.nextInt(),i);
        int q = in.nextInt();
        long a = 0, b = 0;
        while(q-->0) {
            int num = in.nextInt();
            a += hm.get(num);
            b += n-hm.get(num)+1;
        }
        System.out.printf("%d %d\n",a,b);
    }
}