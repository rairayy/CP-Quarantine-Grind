import java.util.*;

public class B1335 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-->0) {
            int len = in.nextInt();
            int subs = in.nextInt();
            int dist = in.nextInt();
            StringBuilder sb = new StringBuilder();
            int ct = 0;
            while(len-->0) {
                sb.append((char)('a'+(ct%dist))+"");
                ct++;
            }
            System.out.println(sb.toString());
        }
    }
}